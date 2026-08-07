package generation;

import ast.core.*;
import ast.python.*;

import java.util.*;


public class PythonDataInterpreter {

    private final Map<String, Object> globalContext = new LinkedHashMap<>();
    private final Map<String, List<String>> routesByFunction = new LinkedHashMap<>();

    public Map<String, Object> getGlobalContext() {
        return globalContext;
    }

    public Map<String, List<String>> getRoutesByFunction() {
        return routesByFunction;
    }

    public void interpret(ProgramNode root) {
        for (ASTNode child : root.getChildren()) {
            if (child instanceof AssignmentNode assign) {
                bindIfSimple(assign);
            } else if (child instanceof FunctionDefNode fn) {
                extractRoutes(fn);
            }
        }
    }

    private void bindIfSimple(AssignmentNode assign) {
        if (assign.getTarget() instanceof IdentifierNode id) {
            globalContext.put(id.getName(), evalExpr(assign.getValue(), globalContext));
        }
    }

    private void extractRoutes(FunctionDefNode fn) {
        List<String> paths = new ArrayList<>();
        for (DecoratorNode dec : fn.getDecorators()) {
            String path = extractRoutePath(dec.getExpression());
            if (path != null) paths.add(path);
        }
        if (!paths.isEmpty()) {
            routesByFunction.put(fn.getName(), paths);
        }
    }

    private String extractRoutePath(ExpressionNode decoratorExpr) {
        if (!(decoratorExpr instanceof CallExpressionNode call)) return null;
        if (!(call.getCallee() instanceof AttributeAccessNode attr)) return null;
        if (!"route".equals(attr.getAttribute())) return null;
        if (call.getArguments().isEmpty()) return null;
        if (call.getArguments().get(0) instanceof StringLiteralNode str) {
            return stripQuotes(str.getValue());
        }
        return null;
    }


    public Object evalExpr(ASTNode node, Map<String, Object> env) {
        if (node == null) return null;

        if (node instanceof StringLiteralNode n) return stripQuotes(n.getValue());
        if (node instanceof NumberLiteralNode n) return parseNumber(n.getValue());
        if (node instanceof BooleanLiteralNode n) return n.getValue();
        if (node instanceof NoneLiteralNode) return null;
        if (node instanceof NullLiteralNode) return null;
        if (node instanceof IdentifierNode n) return env.get(n.getName());

        if (node instanceof ListNode n) {
            List<Object> list = new ArrayList<>();
            for (ExpressionNode el : n.getElements()) list.add(evalExpr(el, env));
            return list;
        }

        if (node instanceof DictNode n) {
            Map<String, Object> map = new LinkedHashMap<>();
            for (KeyValueNode kv : n.getEntries()) {
                map.put(keyToString(kv.getKey()), evalExpr(kv.getValue(), env));
            }
            return map;
        }

        return null;
    }

    private String keyToString(ASTNode keyNode) {
        if (keyNode instanceof IdentifierNode id) return stripQuotes(id.getName());
        return String.valueOf(keyNode);
    }

    private Object parseNumber(String text) {
        try {
            if (text.contains(".")) return Double.parseDouble(text);
            return Long.parseLong(text);
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
}