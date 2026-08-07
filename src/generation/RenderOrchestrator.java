package generation;

import ast.core.*;
import ast.python.*;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;


public class RenderOrchestrator {

    private final ProgramNode pythonRoot;
    private final Map<String, ASTNode> templatesByName;
    private final Path outputDir;
    private final List<String> log = new ArrayList<>();

    public RenderOrchestrator(ProgramNode pythonRoot, Map<String, ASTNode> templatesByName, Path outputDir) {
        this.pythonRoot = pythonRoot;
        this.templatesByName = templatesByName;
        this.outputDir = outputDir;
    }

    public List<String> getLog() {
        return log;
    }

    public void renderAll() {
        PythonDataInterpreter interpreter = new PythonDataInterpreter();
        interpreter.interpret(pythonRoot);
        Map<String, Object> globalContext = interpreter.getGlobalContext();
        JinjaRenderer renderer = new JinjaRenderer(templatesByName, interpreter.getRoutesByFunction());

        List<RenderCall> calls = new ArrayList<>();
        collectRenderTemplateCalls(pythonRoot, calls);

        Set<String> rendered = new LinkedHashSet<>();
        for (RenderCall call : calls) {
            if (rendered.contains(call.templateName)) continue; // first call wins

            if (!templatesByName.containsKey(call.templateName)) {
                log.add("Skipped rendering '" + call.templateName + "': template not found on disk");
                continue;
            }

            Map<String, Object> renderContext = new LinkedHashMap<>();
            for (var entry : call.kwargs.entrySet()) {
                Object value = interpreter.evalExpr(entry.getValue(), globalContext);
                if (value == null) {
                    Object fallback = fallbackSampleValue(globalContext);
                    if (fallback != null) {
                        log.add("'" + entry.getKey() + "' for '" + call.templateName +
                                "' could not be statically resolved (likely request-time data) -- using sample data");
                        value = fallback;
                    }
                }
                renderContext.put(entry.getKey(), value);
            }

            String html = renderer.render(call.templateName, renderContext);
            if (html == null) continue;

            try {
                Files.createDirectories(outputDir);
                Path outFile = outputDir.resolve(call.templateName);
                Files.writeString(outFile, html);
                log.add("Rendered " + call.templateName + " -> " + outFile);
                rendered.add(call.templateName);
            } catch (IOException e) {
                log.add("ERROR writing rendered " + call.templateName + ": " + e.getMessage());
            }
        }

        for (String err : renderer.getRenderErrors()) {
            log.add("[Render warning] " + err);
        }
    }

    private Object fallbackSampleValue(Map<String, Object> globalContext) {
        for (Object v : globalContext.values()) {
            if (v instanceof List<?> list && !list.isEmpty()) return list.get(0);
        }
        return null;
    }

    private record RenderCall(String templateName, Map<String, ExpressionNode> kwargs) {}

    private void collectRenderTemplateCalls(ASTNode node, List<RenderCall> out) {
        if (node instanceof CallExpressionNode call &&
                call.getCallee() instanceof IdentifierNode id &&
                "render_template".equals(id.getName()) &&
                !call.getArguments().isEmpty() &&
                call.getArguments().get(0) instanceof StringLiteralNode nameNode) {

            Map<String, ExpressionNode> kwargs = new LinkedHashMap<>();
            for (int i = 1; i < call.getArguments().size(); i++) {
                if (call.getArguments().get(i) instanceof KeywordArgumentNode kw) {
                    kwargs.put(kw.getKey(), kw.getValue());
                }
            }
            out.add(new RenderCall(stripQuotes(nameNode.getValue()), kwargs));
        }

        for (ASTNode child : node.getChildren()) {
            collectRenderTemplateCalls(child, out);
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