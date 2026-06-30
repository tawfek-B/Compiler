package ast.core;

import ast.core.*;
import ast.html.*;
import ast.css.*;
import ast.jinja.*;
import org.w3c.dom.html.HTMLElement;

public interface HtmlWithCssVisitor <T>{

    T visit(HtmlNode node);
    T visit(HtmlAttributeNode node);
    T visit(CDataNode node);
    T visit(HtmlCommentNode node);
    T visit(HtmlDocumentNode node);
    T visit(HtmlDoctypeNode node);
    T visit(HtmlTextNode node);
    T visit(HtmlTagNode node);


    T visit(CssNode node);
    T visit(CssAtRuleNode node);
    T visit(CssRuleNode node);
    T visit(CssDeclarationNode node);
    T visit(CssDocumentNode node);
    T visit(CssKeyframeBlockNode node);
    T visit(CssKeyframeDeclarationNode node);
    T visit(CssKeyframeSelectorNode node);
    T visit(CssKeyframesNode node);
    T visit(CssMarginRuleNode node);
    T visit(CssMediaQueryNode node);
    T visit(CssMediaRuleNode node);
    T visit(CssSelectorNode node);

    T visit(JinjaNode node);
    T visit(JinjaBlockNode node);
    T visit(JinjaCommentNode node);
    T visit(JinjaDocumentNode node);
    T visit(JinjaExpressionNode node);
    T visit(JinjaForNode node);
    T visit(JinjaIfNode node);
    T visit(JinjaRawHtmlNode node);
    T visit(JinjaVarNode node);


    T visit(ProgramNode node);
    T visit(BlockNode node);

    // Statements
    T visit(StatementNode node);
    T visit(AssignmentNode node);
    T visit(ReturnNode node);

    // Expressions
    T visit(ExpressionNode node);
    T visit(BinaryExpressionNode node);
    T visit(UnaryExpressionNode node);
    T visit(CallExpressionNode node);

    // Identifiers & Literals
    T visit(IdentifierNode node);
    T visit(NumberLiteralNode node);
    T visit(StringLiteralNode node);
    T visit(BooleanLiteralNode node);
    T visit(NullLiteralNode node);

    T visit(JinjaEndNode jinjaEndNode);

    T visit(JinjaExtendNode jinjaExtendNode);

    T visit(MixedWebNode mixedWebNode);
}
