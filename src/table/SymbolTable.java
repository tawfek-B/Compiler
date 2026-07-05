package table;

import java.util.*;

public class SymbolTable {

    public Scope currentScope;
    private Scope globalScope;
    private String currentFileOrigin = "unknown";  // NEW: track which file we're processing
    private final Map<String, Map<String, Symbol>> templateContexts = new HashMap<>();

    public SymbolTable() {
        globalScope = new Scope("global", null, currentFileOrigin);
        currentScope = globalScope;
    }

    // NEW: Set the current file origin before processing a file
    public void setCurrentFileOrigin(String fileOrigin) {
        this.currentFileOrigin = fileOrigin != null ? fileOrigin : "unknown";
    }

    // Add this to SymbolTable.java
    public Scope findScope(String name) {
        return findScopeRecursive(globalScope, name);
    }

    private Scope findScopeRecursive(Scope scope, String name) {
        if (scope.getName().equals(name)) return scope;
        for (Scope child : scope.getChildren()) {
            Scope found = findScopeRecursive(child, name);
            if (found != null) return found;
        }
        return null;
    }

    public String getCurrentFileOrigin() {
        return currentFileOrigin;
    }

    public void enterScope(String scopeName) {
        currentScope = new Scope(scopeName, currentScope,  currentFileOrigin);
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

    /**
     * Called by Python's DefinitionVisitor when it sees render_template(...)
     */
    public void registerTemplateContext(String templateName, Map<String, Symbol> context) {
        templateContexts.put(templateName, context);
    }

    /**
     * Called by Main.java before processing an HTML file
     */
    public Map<String, Symbol> getTemplateContext(String templateName) {
        return templateContexts.get(templateName);
    }
    public Set<String> getRegisteredTemplateNames() {
        return templateContexts.keySet();
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
        globalScope = new Scope("global", null,  currentFileOrigin);
        currentScope = globalScope;
    }

    public void printScopeTree() {
        System.out.println("\n===== SYMBOL TABLE (Complete Scope Tree) =====\n");
        printScopeRecursive(globalScope, 0);
    }

    private void printScopeRecursive(Scope scope, int depth) {
        String indent = "  ".repeat(depth);
        System.out.println(indent + "┌─ Scope: " + scope.getName() + "\t\t\t" + scope.getFileOrigin());
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