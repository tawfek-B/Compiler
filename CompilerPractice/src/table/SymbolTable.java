package table;

import java.util.*;

public class SymbolTable {

    private Scope currentScope ;
    private final Scope root;

    public SymbolTable() {
        root = new Scope("global", null);
        currentScope = root;
    }

    //Scope Management

    public void enterScope(String scopeName) {
        Scope newScope = new Scope(scopeName, currentScope);
        currentScope.addChild(newScope);
        currentScope = newScope;
    }

    public void exitScope() {
        if(currentScope.getParent() != null){
            currentScope = currentScope.getParent();
        }
    }

    public Scope getCurrentScope() {
        return currentScope;
    }

    //Symbol Management

    public boolean define(Symbol symbol){
        return currentScope.define(symbol);
    }

    public Symbol resolve(String name){
        Scope scope = currentScope;

        while(scope != null){
            Symbol symbol = scope.resolveLocal(name);
            if(symbol != null){
                return  symbol;
            }
            scope = scope.getParent();
        }
        return null;
    }


    public boolean existsInCurrentScope(String name) {
        return currentScope.resolveLocal(name) != null;
    }

    public void clear() {
        currentScope = root;
        root.getChildren().clear();
        root.getSymbols().clear();
    }


    public void print() {
        System.out.println("\n===== SYMBOL TABLE (Hierarchical) =====\n");
        printScope(root, "", true);
    }

    private void printScope(Scope scope, String prefix, boolean isLast) {
        if (scope == null) return;

        String connector = isLast ? "└── " : "├── ";
        System.out.println(prefix + connector + "Scope: " + scope.getName());

        // Print symbols
        if (!scope.getSymbols().isEmpty()) {
            for (Symbol s : scope.getSymbols().values()) {
                System.out.println(prefix + (isLast ? "    " : "│   ") + "• " + s);
            }
        }

        // Print children
        List<Scope> children = scope.getChildren();
        for (int i = 0; i < children.size(); i++) {
            boolean lastChild = (i == children.size() - 1);
            printScope(
                    children.get(i),
                    prefix + (isLast ? "    " : "│   "),
                    lastChild
            );
        }
    }

}
