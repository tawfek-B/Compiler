package ast;

import ast.core.*;
import ast.python.*;
import ast.html.*;
import ast.css.*;
import ast.jinja2.*;

    public interface ASTVisitor<T> {
        T visit(ProgramNode node);
        T visit(IdentifierNode node);
        T visit(NumberNode node);
        T visit(StringNode node);
        T visit(BooleanNode node);
        T visit(BinaryNode node);
        T visit(UnaryNode node);
        T visit(ListNode node);
        T visit(DictNode node);
        T visit(DictEntryNode node);

        // Python nodes
        T visit(pyFunctionDecNode node);
        T visit(pyFunctionCallNode node);
        T visit(pyReturnNode node);
        T visit(pyAssignNode node);
        T visit(pyIfNode node);
        T visit(pyElifNode node);
        T visit(pyElseNode node);
        T visit(pyForNode node);
        T visit(pyForEachNode node);
        T visit(FlaskRouteNode node);

        // HTML nodes
        T visit(HtmlDocumentNode node);
        T visit(HtmlTagNode node);
        T visit(HtmlAttributeNode node);
        T visit(HtmlTextNode node);
        T visit(HtmlCommentNode node);
        T visit(CDataNode node);


        // CSS nodes
        T visit(CssRuleNode node);
        T visit(CssSelectorNode node);
        T visit(CssDeclarationNode node);
        T visit(CssDocumentNode node);
        T visit(CssAtRuleNode node);
        T visit(CssMediaRuleNode node);
        T visit(CssMediaQueryNode node);
        T visit(CssKeyframeBlockNode node);
        T visit(CssKeyframeSelectorNode node);
        T visit(CssKeyframeDeclarationNode node);
        T visit(CssKeyframesNode node);



        // Jinja nodes
        T visit(JinjaIfNode node);
        T visit(JinjaForNode node);
        T visit(JinjaVarNode node);
        T visit(JinjaExpressionNode node);
        T visit(JinjaBlockNode node);
        T visit(JinjaDocumentNode node);
        T visit(JinjaCommentNode node);
        T visit(JinjaRawHtmlNode node);

}
