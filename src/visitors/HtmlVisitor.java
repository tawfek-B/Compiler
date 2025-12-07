package visitors;

import ast.html.*;

public interface HtmlVisitor<T>{
    T visit(HtmlDocumentNode node);
    T visit(HtmlTextNode node);
    T visit(HtmlAttributeNode node);
    T visit(HtmlTagNode node);
    T visit(HtmlCommentNode node);
    T visit(CDataNode node);
}
