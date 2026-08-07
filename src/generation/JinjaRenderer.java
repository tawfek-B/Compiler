package generation;

import ast.core.*;
import ast.python.*;
import ast.html.*;
import ast.css.*;
import ast.jinja.*;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;


public class JinjaRenderer {

    private final Map<String, ASTNode> templatesByName;
    private final Map<String, List<String>> routesByFunction;
    private final List<String> renderErrors = new ArrayList<>();

    private static final java.util.regex.Pattern SEGMENT_PATTERN =
            java.util.regex.Pattern.compile("<(?:\\w+:)?(\\w+)>");

    private static final Set<String> VOID_ELEMENTS = Set.of(
            "area", "base", "br", "col", "embed", "hr", "img", "input",
            "link", "meta", "param", "source", "track", "wbr"
    );

    public JinjaRenderer(Map<String, ASTNode> templatesByName, Map<String, List<String>> routesByFunction) {
        this.templatesByName = templatesByName;
        this.routesByFunction = routesByFunction;
    }

    public List<String> getRenderErrors() {
        return renderErrors;
    }

    /** Tracks which {% block %} override is currently active, and the
     *  ROOT template's own default body for it, so super() works. */
    private static class BlockFrame {
        final List<ASTNode> rootDefaultBody;
        BlockFrame(List<ASTNode> rootDefaultBody) {
            this.rootDefaultBody = rootDefaultBody;
        }
    }

    private static class RenderState {
        final Map<String, JinjaBlockNode> overrides;
        final Deque<BlockFrame> activeBlocks = new ArrayDeque<>();
        RenderState(Map<String, JinjaBlockNode> overrides) {
            this.overrides = overrides;
        }
    }

    public String render(String templateName, Map<String, Object> context) {
        ASTNode leaf = templatesByName.get(templateName);
        if (leaf == null) {
            renderErrors.add("Cannot render '" + templateName + "': template not found");
            return null;
        }

        List<ASTNode> chain = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        ASTNode current = leaf;
        chain.add(current);
        while (true) {
            String parentName = findFirstExtendsTarget(current);
            if (parentName == null || !visited.add(parentName)) break;
            ASTNode parent = templatesByName.get(parentName);
            if (parent == null) {
                renderErrors.add("'" + templateName + "' extends '" + parentName +
                        "' but it was not found on disk -- rendering without that layout");
                break;
            }
            chain.add(parent);
            current = parent;
        }

        ASTNode root = chain.get(chain.size() - 1);

        Map<String, JinjaBlockNode> overrides = new LinkedHashMap<>();
        for (int i = 0; i < chain.size() - 1; i++) {
            collectBlocks(chain.get(i), overrides);
        }

        return renderNode(root, context, new RenderState(overrides));
    }

    private String findFirstExtendsTarget(ASTNode node) {
        for (ASTNode child : node.getChildren()) {
            if (child instanceof JinjaExtendNode ext) return stripQuotes(ext.getPath());
        }
        return null;
    }

    private void collectBlocks(ASTNode node, Map<String, JinjaBlockNode> out) {
        if (node instanceof JinjaBlockNode block && block.getJinjaType() == JinjaBlockNode.BlockType.BLOCK) {
            String name = blockName(block);
            if (name != null) out.putIfAbsent(name, block);
        }
        for (ASTNode child : node.getChildren()) collectBlocks(child, out);
    }

    private String blockName(JinjaBlockNode block) {
        return (block.getBlockName() instanceof IdentifierNode id) ? id.getName() : null;
    }

    // ==================== Rendering ====================

    private String renderNode(ASTNode node, Map<String, Object> ctx, RenderState state) {
        if (node == null) return "";

        if (node instanceof HtmlDocumentNode n) return renderChildren(n.getChildren(), ctx, state);
        if (node instanceof HtmlDoctypeNode n) return n.getText();
        if (node instanceof HtmlTagNode n) return renderTag(n, ctx, state);
        if (node instanceof HtmlTextNode n) return n.getText();
        if (node instanceof HtmlCommentNode n) {
            String c = n.getComment();
            return (c != null && c.trim().startsWith("<!--")) ? c : "<!--" + c + "-->";
        }
        if (node instanceof CDataNode n) return "<![CDATA[" + n.getData() + "]]>";
        if (node instanceof CssDocumentNode n) return renderCss(n);

        if (node instanceof JinjaCommentNode) return "";       // Jinja comments never render
        if (node instanceof JinjaExtendNode) return "";        // handled by the chain walk, not inline
        if (node instanceof JinjaEndNode n) {
            renderErrors.add("Unmatched '{% " + n.getRaw() + " %}' at line " + n.getLine() + " -- dropped from output");
            return "";
        }
        if (node instanceof JinjaExpressionNode n) return toDisplayString(evalExpr(n.getExpression(), ctx, state));
        if (node instanceof JinjaBlockNode n) return renderBlock(n, ctx, state);

        return "";
    }

    private String renderChildren(List<ASTNode> children, Map<String, Object> ctx, RenderState state) {
        StringBuilder sb = new StringBuilder();
        for (ASTNode child : children) sb.append(renderNode(child, ctx, state));
        return sb.toString();
    }

    private String renderTag(HtmlTagNode tag, Map<String, Object> ctx, RenderState state) {
        StringBuilder sb = new StringBuilder("<").append(tag.getTagName());
        for (HtmlAttributeNode attr : tag.getAttributes()) {
            sb.append(" ").append(renderAttribute(attr, ctx, state));
        }

        List<ASTNode> body = tag.getChildren().stream()
                .filter(c -> !(c instanceof HtmlAttributeNode))
                .toList();

        if (body.isEmpty() && VOID_ELEMENTS.contains(tag.getTagName())) {
            sb.append(" />");
            return sb.toString();
        }

        sb.append(">").append(renderChildren(body, ctx, state))
                .append("</").append(tag.getTagName()).append(">");
        return sb.toString();
    }

    private String renderAttribute(HtmlAttributeNode attr, Map<String, Object> ctx, RenderState state) {
        List<ASTNode> children = attr.getChildren();
        if (!children.isEmpty()) {
            StringBuilder value = new StringBuilder();
            for (ASTNode child : children) {
                if (child instanceof HtmlTextNode text) {
                    value.append(text.getText());
                } else if (child instanceof JinjaExpressionNode expr) {
                    value.append(toDisplayString(evalExpr(expr.getExpression(), ctx, state)));
                }
            }
            return attr.getName() + "=\"" + value + "\"";
        }
        String value = attr.getValue();
        if (value == null || value.isEmpty()) return attr.getName();
        return attr.getName() + "=\"" + value + "\"";
    }

    private String renderCss(CssDocumentNode doc) {
        StringBuilder sb = new StringBuilder();
        for (CssRuleNode rule : doc.getRules()) {
            List<CssSelectorNode> selectors = rule.getSelectors();
            for (int i = 0; i < selectors.size(); i++) {
                if (i > 0) sb.append(", ");
                sb.append(selectors.get(i).getSelector());
            }
            sb.append(" {\n");
            for (CssDeclarationNode decl : rule.getDeclarations()) {
                sb.append("    ").append(decl.getProperty()).append(": ").append(decl.getValue());
                if (decl.isImportant()) sb.append(" !important");
                sb.append(";\n");
            }
            sb.append("}\n");
        }
        return sb.toString();
    }

    private String renderBlock(JinjaBlockNode node, Map<String, Object> ctx, RenderState state) {
        switch (node.getJinjaType()) {
            case BLOCK -> {
                String name = blockName(node);
                JinjaBlockNode override = name != null ? state.overrides.get(name) : null;
                if (override != null) {
                    // Mark this block as consumed so duplicate declarations
                    // in the same parent don't re-render the same override.
                    state.overrides.remove(name);
                    state.activeBlocks.push(new BlockFrame(node.getBody()));
                    String result = renderChildren(override.getBody(), ctx, state);
                    state.activeBlocks.pop();
                    return result;
                }
                return renderChildren(node.getBody(), ctx, state);
            }
            case FOR -> {
                return renderFor(node, ctx, state);
            }
            case WITH -> {
                Map<String, Object> childCtx = new HashMap<>(ctx);
                for (JinjaWithAssignmentNode assign : node.getAssignments()) {
                    childCtx.put(assign.getName(), evalExpr(assign.getValue(), ctx, state));
                }
                return renderChildren(node.getBody(), childCtx, state);
            }
            case IF -> {
                boolean truthy = isTruthy(evalExpr(node.getCondition(), ctx, state));
                List<ASTNode> body = node.getBody();
                int split = node.getElseStartIndex();
                boolean hasElse = node.getElseBlock() != null && split >= 0 && split <= body.size();
                if (truthy) return renderChildren(hasElse ? body.subList(0, split) : body, ctx, state);
                if (hasElse) return renderChildren(body.subList(split, body.size()), ctx, state);
                return "";
            }
            default -> {
                renderErrors.add("Unknown Jinja tag at line " + node.getLine() + " -- skipped during render");
                return "";
            }
        }
    }

    private String renderFor(JinjaBlockNode node, Map<String, Object> ctx, RenderState state) {
        Object iterableVal = evalExpr(node.getIterable(), ctx, state);
        List<ASTNode> body = node.getBody();
        int split = node.getElseStartIndex();
        boolean hasElse = node.getElseBlock() != null && split >= 0 && split <= body.size();
        List<ASTNode> mainBody = hasElse ? body.subList(0, split) : body;
        List<ASTNode> elseBody = hasElse ? body.subList(split, body.size()) : List.of();

        List<?> items = (iterableVal instanceof List<?> l) ? l : null;
        if (items == null || items.isEmpty()) {
            return hasElse ? renderChildren(elseBody, ctx, state) : "";
        }

        StringBuilder sb = new StringBuilder();
        for (Object item : items) {
            Map<String, Object> loopCtx = new HashMap<>(ctx);
            bindLoopTarget(node.getLoopVariable(), item, loopCtx);
            sb.append(renderChildren(mainBody, loopCtx, state));
        }
        return sb.toString();
    }

    private void bindLoopTarget(ASTNode target, Object item, Map<String, Object> ctx) {
        if (target instanceof IdentifierNode id) {
            ctx.put(id.getName(), item);
        } else if (target instanceof TupleExpressionNode tuple && item instanceof List<?> values) {
            List<ExpressionNode> names = tuple.getElements();
            for (int i = 0; i < names.size() && i < values.size(); i++) {
                if (names.get(i) instanceof IdentifierNode id) ctx.put(id.getName(), values.get(i));
            }
        }
    }

    // ==================== Expression evaluation ====================

    private Object evalExpr(ASTNode node, Map<String, Object> ctx, RenderState state) {
        if (node == null) return null;

        if (node instanceof IdentifierNode n) return ctx.get(n.getName());
        if (node instanceof StringLiteralNode n) return stripQuotes(n.getValue());
        if (node instanceof NumberLiteralNode n) return parseNumber(n.getValue());
        if (node instanceof BooleanLiteralNode n) return n.getValue();
        if (node instanceof NoneLiteralNode) return null;
        if (node instanceof NullLiteralNode) return null;

        if (node instanceof AttributeAccessNode n) {
            Object obj = evalExpr(n.getObject(), ctx, state);
            return (obj instanceof Map<?, ?> map) ? map.get(n.getAttribute()) : null;
        }
        if (node instanceof SubscriptionNode n) {
            Object obj = evalExpr(n.getObject(), ctx, state);
            Object idx = evalExpr(n.getIndex(), ctx, state);
            if (obj instanceof List<?> list && idx instanceof Number num) {
                int i = num.intValue();
                return (i >= 0 && i < list.size()) ? list.get(i) : null;
            }
            if (obj instanceof Map<?, ?> map) return map.get(String.valueOf(idx));
            return null;
        }
        if (node instanceof ComparisonNode n) {
            return compare(evalExpr(n.getLeft(), ctx, state), n.getOperator(), evalExpr(n.getRight(), ctx, state));
        }
        if (node instanceof LogicalExpressionNode n) {
            boolean l = isTruthy(evalExpr(n.getLeft(), ctx, state));
            return "and".equals(n.getOperator()) ? (l && isTruthy(evalExpr(n.getRight(), ctx, state)))
                    : (l || isTruthy(evalExpr(n.getRight(), ctx, state)));
        }
        if (node instanceof UnaryExpressionNode n) {
            Object v = evalExpr(n.getOperand(), ctx, state);
            return "not".equals(n.getOperator()) ? !isTruthy(v) : v;
        }
        if (node instanceof BinaryExpressionNode n) {
            if ("|".equals(n.getOperator())) return applyFilter(n, ctx, state);
            Object l = evalExpr(n.getLeft(), ctx, state);
            Object r = evalExpr(n.getRight(), ctx, state);
            if ("+".equals(n.getOperator())) {
                if (l instanceof String || r instanceof String) return toDisplayString(l) + toDisplayString(r);
                if (l instanceof Number ln && r instanceof Number rn) return ln.doubleValue() + rn.doubleValue();
            }
            return null;
        }
        if (node instanceof ListNode n) {
            List<Object> list = new ArrayList<>();
            for (ExpressionNode el : n.getElements()) list.add(evalExpr(el, ctx, state));
            return list;
        }
        if (node instanceof DictNode n) {
            Map<String, Object> map = new LinkedHashMap<>();
            for (KeyValueNode kv : n.getEntries()) {
                String key = (kv.getKey() instanceof IdentifierNode id) ? stripQuotes(id.getName()) : String.valueOf(kv.getKey());
                map.put(key, evalExpr(kv.getValue(), ctx, state));
            }
            return map;
        }
        if (node instanceof CallExpressionNode n) return evalCall(n, ctx, state);

        return null;
    }

    private Object evalCall(CallExpressionNode call, Map<String, Object> ctx, RenderState state) {
        String name = (call.getCallee() instanceof IdentifierNode id) ? id.getName() : null;
        if (name == null) return null;

        return switch (name) {
            case "url_for" -> resolveUrlFor(call, ctx, state);
            case "get_flashed_messages" -> new ArrayList<>(); // no real flash queue at generation time
            case "super" -> {
                BlockFrame frame = state.activeBlocks.peek();
                if (frame == null) {
                    renderErrors.add("'{{ super() }}' used outside an overridden block -- ignored");
                    yield "";
                }
                yield renderChildren(frame.rootDefaultBody, ctx, state);
            }
            case "format" -> call.getArguments().isEmpty() ? "" :
                    toDisplayString(evalExpr(call.getArguments().get(0), ctx, state));
            default -> {
                renderErrors.add("Undefined function '" + name + "()' called at line " +
                        call.getLine() + " -- rendered as empty");
                yield "";
            }
        };
    }

    private String resolveUrlFor(CallExpressionNode call, Map<String, Object> ctx, RenderState state) {
        List<ExpressionNode> args = call.getArguments();
        if (args.isEmpty() || !(args.get(0) instanceof StringLiteralNode endpointNode)) {
            renderErrors.add("url_for() at line " + call.getLine() + " requires an endpoint name -- rendered as '#'");
            return "#";
        }
        String endpoint = stripQuotes(endpointNode.getValue());

        Map<String, Object> kwargs = new LinkedHashMap<>();
        for (int i = 1; i < args.size(); i++) {
            if (args.get(i) instanceof KeywordArgumentNode kw) kwargs.put(kw.getKey(), evalExpr(kw.getValue(), ctx, state));
        }

        List<String> candidates = routesByFunction.get(endpoint);
        if (candidates == null || candidates.isEmpty()) {
            renderErrors.add("url_for('" + endpoint + "') at line " + call.getLine() +
                    ": no matching @app.route found -- rendered as '#'");
            return "#";
        }

        String chosen = candidates.get(0);
        for (String candidate : candidates) {
            if (kwargs.keySet().containsAll(extractPlaceholders(candidate))) {
                chosen = candidate;
                break;
            }
        }

        Set<String> usedKeys = new HashSet<>();
        String path = SEGMENT_PATTERN.matcher(chosen).replaceAll(mr -> {
            String paramName = mr.group(1);
            usedKeys.add(paramName);
            Object val = kwargs.get(paramName);
            return val != null ? urlEncode(toDisplayString(val)) : mr.group(0);
        });

        StringBuilder query = new StringBuilder();
        for (var entry : kwargs.entrySet()) {
            if (usedKeys.contains(entry.getKey())) continue;
            query.append(query.isEmpty() ? "?" : "&")
                    .append(urlEncode(entry.getKey())).append("=").append(urlEncode(toDisplayString(entry.getValue())));
        }
        return path + query;
    }

    private List<String> extractPlaceholders(String routePattern) {
        List<String> names = new ArrayList<>();
        var m = SEGMENT_PATTERN.matcher(routePattern);
        while (m.find()) names.add(m.group(1));
        return names;
    }

    private String urlEncode(String s) {
        return URLEncoder.encode(s, StandardCharsets.UTF_8).replace("+", "%20");
    }

    private Object applyFilter(BinaryExpressionNode filterExpr, Map<String, Object> ctx, RenderState state) {
        Object value = evalExpr(filterExpr.getLeft(), ctx, state);
        if (!(filterExpr.getRight() instanceof CallExpressionNode filterCall)) return value;
        String filterName = (filterCall.getCallee() instanceof IdentifierNode id) ? id.getName() : null;
        if (filterName == null) return value;

        List<Object> args = new ArrayList<>();
        args.add(value);
        for (ExpressionNode arg : filterCall.getArguments()) args.add(evalExpr(arg, ctx, state));

        if ("format".equals(filterName)) {
            return pythonPercentFormat(String.valueOf(args.get(0)), args.subList(1, args.size()));
        }

        renderErrors.add("Unsupported Jinja filter '" + filterName + "' at line " +
                filterExpr.getLine() + " -- value passed through unfiltered");
        return value;
    }

    private String pythonPercentFormat(String formatStr, List<Object> args) {
        var m = java.util.regex.Pattern.compile("%\\.(\\d+)f").matcher(formatStr);
        if (m.find() && !args.isEmpty() && args.get(0) instanceof Number num) {
            return String.format("%." + Integer.parseInt(m.group(1)) + "f", num.doubleValue());
        }
        return !args.isEmpty() ? toDisplayString(args.get(0)) : formatStr;
    }

    // ==================== Helpers ====================

    private boolean isTruthy(Object v) {
        if (v == null) return false;
        if (v instanceof Boolean b) return b;
        if (v instanceof String s) return !s.isEmpty();
        if (v instanceof List<?> l) return !l.isEmpty();
        if (v instanceof Map<?, ?> m) return !m.isEmpty();
        if (v instanceof Number n) return n.doubleValue() != 0;
        return true;
    }

    private Object compare(Object l, String op, Object r) {
        return switch (op) {
            case "==", "is" -> Objects.equals(l, r);
            case "!=" -> !Objects.equals(l, r);
            case "<", "<=", ">", ">=" -> {
                if (l instanceof Number ln && r instanceof Number rn) {
                    int cmp = Double.compare(ln.doubleValue(), rn.doubleValue());
                    yield switch (op) {
                        case "<" -> cmp < 0;
                        case "<=" -> cmp <= 0;
                        case ">" -> cmp > 0;
                        default -> cmp >= 0;
                    };
                }
                yield false;
            }
            default -> false;
        };
    }

    private Object parseNumber(String text) {
        try {
            return text.contains(".") ? Double.parseDouble(text) : (Object) Long.parseLong(text);
        } catch (NumberFormatException e) {
            return text;
        }
    }

    private String stripQuotes(String s) {
        if (s == null) return null;
        if (s.length() >= 2 &&
                ((s.startsWith("\"") && s.endsWith("\"")) || (s.startsWith("'") && s.endsWith("'")))) {
            return s.substring(1, s.length() - 1);
        }
        return s;
    }

    private String toDisplayString(Object v) {
        if (v == null) return "";
        if (v instanceof Double d) {
            return (d == Math.floor(d) && !d.isInfinite()) ? String.valueOf(d.longValue()) : String.valueOf(d);
        }
        return String.valueOf(v);
    }
}