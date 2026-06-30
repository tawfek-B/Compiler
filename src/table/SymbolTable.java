package table;

import java.util.*;

public class SymbolTable {

    public Scope currentScope;
    private Scope globalScope;
    private String currentFileOrigin = "unknown";  // NEW: track which file we're processing

    public SymbolTable() {
        globalScope = new Scope("global", null);
        currentScope = globalScope;
    }

    // NEW: Set the current file origin before processing a file
    public void setCurrentFileOrigin(String fileOrigin) {
        this.currentFileOrigin = fileOrigin != null ? fileOrigin : "unknown";
    }

    public String getCurrentFileOrigin() {
        return currentFileOrigin;
    }

    public void enterScope(String scopeName) {
        currentScope = new Scope(scopeName, currentScope);
    }

    public void exitScope() {
        if (currentScope.getParent() != null) {
            currentScope = currentScope.getParent();
        }
    }

    public void exitAllScopes() {
        while (currentScope.getParent() != null) {
            currentScope = currentScope.getParent();
        }
    }

    public Scope getCurrentScope() { return currentScope; }
    public Scope getGlobalScope() { return globalScope; }

    public boolean define(Symbol symbol) {
        return currentScope.define(symbol);
    }

    // NEW: Convenience method that auto-sets file origin
    public boolean defineWithOrigin(Symbol symbol) {
        // If symbol was created without file origin, wrap it with current origin
        if ("unknown".equals(symbol.getFileOrigin()) && !"unknown".equals(currentFileOrigin)) {
            symbol = new Symbol(
                    symbol.getName(),
                    symbol.getType(),
                    symbol.getKind(),
                    symbol.getLine(),
                    symbol.getColumn(),
                    currentFileOrigin
            );
        }
        return currentScope.define(symbol);
    }

    public Symbol resolve(String name) {
        Scope scope = currentScope;
        while (scope != null) {
            Symbol symbol = scope.resolveLocal(name);
            if (symbol != null) return symbol;
            scope = scope.getParent();
        }
        return null;
    }

    public Symbol resolveLocal(String name) {
        return currentScope.resolveLocal(name);
    }

    public boolean existsInCurrentScope(String name) {
        return currentScope.resolveLocal(name) != null;
    }

    // FIXED: Properly reset the entire scope tree
    public void clear() {
        // Orphan all child scopes by clearing the global's children list
        // Then create a fresh global scope so old references are truly discarded
        globalScope = new Scope("global", null);
        currentScope = globalScope;
    }

    public void printScopeTree() {
        System.out.println("\n===== SYMBOL TABLE (Complete Scope Tree) =====\n");
        printScopeRecursive(globalScope, 0);
    }

    private void printScopeRecursive(Scope scope, int depth) {
        String indent = "  ".repeat(depth);
        System.out.println(indent + "┌─ Scope: " + scope.getName());
        System.out.println(indent + "│  " + "-".repeat(70));

        if (scope.getSymbols().isEmpty()) {
            System.out.println(indent + "│  (empty)");
        } else {
            for (Symbol sym : scope.getSymbols().values()) {
                System.out.println(indent + "│  " + sym);
            }
        }
        System.out.println(indent + "└" + "─".repeat(72));

        for (Scope child : scope.getChildren()) {
            printScopeRecursive(child, depth + 1);
        }
    }

    public void printCurrentScopeChain() {
        Scope scope = currentScope;
        System.out.println("\n===== SYMBOL TABLE (Active Scope Chain) =====\n");
        while (scope != null) {
            System.out.println("Scope: " + scope.getName());
            System.out.println("-".repeat(90));
            scope.getSymbols().values().forEach(System.out::println);
            System.out.println();
            scope = scope.getParent();
        }
    }
}