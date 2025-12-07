package visitors;

import ast.jinja.*;

public interface JinjaVisitor<T>{

    T visit(JinjaBlockNode node);
    T visit(JinjaCommentNode node);
    T visit(JinjaIfNode node);
    T visit(JinjaForNode node);
    T visit(JinjaRawHtmlNode node);
    T visit(JinjaVarNode node);
    T visit(JinjaExpressionNode node);
    T visit(JinjaDocumentNode node);
}
