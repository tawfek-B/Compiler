package visitors;

import ast.core.ASTNode;
import table.Symbol;
import table.SymbolTable;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class TypeCheckVisitor {
    // TODO: fill the occurrences list of objects for each symbol from BASE VISITOR

    public TypeCheckVisitor(SymbolTable symbolTable) {
        // TODO: we should go into each scope, not just global, when scopes are being correctly populated
        symbolTable.enterScope("global");

        for (Map.Entry<String, Symbol> symbolTableSymbol: symbolTable.currentScope.symbols.entrySet()) {
            // check type change errors
            Symbol lastOccurrence = symbolTableSymbol.getValue().symbolOccurrences.symbols.get(0);
            for (Symbol occurrence: symbolTableSymbol.getValue().symbolOccurrences.symbols) {
                if (occurrence.type != lastOccurrence.type) {
                    // print error, return, whatever you want
                }
            }
            // check names duplication
            List<Symbol> symbolList = new ArrayList<>(symbolTable.currentScope.symbols.values());
            for (Symbol symbol: symbolList) {
                if (symbolList.stream().anyMatch(s -> s.name.equals(symbol.name))) {
                    // print error, return, whatever you want
                }
            }
        }
    }

    public void visit(ASTNode root) {
    }
}
