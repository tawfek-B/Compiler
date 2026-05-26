package ast.core;


import java.util.ArrayList;
import java.util.List;

public class MixedWebNode extends ASTNode {

    private final List<ASTNode> pythonModules = new ArrayList<>();
    private final List<ASTNode> templates = new ArrayList<>();

    public MixedWebNode(int line, int column) {
        super(line, column);
    }

    public void addPythonModule(ASTNode module) {
        pythonModules.add(module);
        add(module);
    }

    public void addTemplate(ASTNode template) {
        templates.add(template);
        add(template);
    }

    public List<ASTNode> getPythonModules() { return pythonModules; }
    public List<ASTNode> getTemplates() { return templates; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public <T> T accept(HtmlWithCssVisitor<T> visitor) {
        return visitor.visit(this);
    }
}