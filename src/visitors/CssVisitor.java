package visitors;

import ast.css.*;

public interface CssVisitor<T>{

    T visit(CssRuleNode node);
    T visit(CssMediaRuleNode node);
    T visit(CssMediaQueryNode node);
    T visit(CssKeyframeBlockNode node);
    T visit(CssDocumentNode node);
    T visit(CssDeclarationNode node);
    T visit(CssSelectorNode node);
    T visit(CssMarginRuleNode node);
    T visit(CssKeyframeDeclarationNode node);
    T visit(CssKeyframesNode node);
    T visit(CssAtRuleNode node);
    T visit(CssKeyframeSelectorNode node);
}
