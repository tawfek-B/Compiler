package table;

import java.util.*;

public class SymbolTable {

    private final Map<String, List<SymbolRow>> scopes = new LinkedHashMap<>();
    private final Deque<String> scopeStack = new ArrayDeque<>();

    public SymbolTable() {
        enterScope("global");
    }

    //Scope Management

    public void enterScope(String scopeName) {
        scopeStack.push(scopeName);
        scopes.putIfAbsent(scopeName, new ArrayList<>());
    }

    public void exitScope() {
        if (scopeStack.size() > 1) {
            scopeStack.pop();
        }
    }

    public String getCurrentScope() {
        return scopeStack.peek();
    }

    //Symbol Management

    public SymbolRow addSymbol(
            String name,
            String type,
            String value,
            int line,
            int column
    ) {
        SymbolRow row = new SymbolRow(
                name,
                type,
                value,
                line,
                column,
                getCurrentScope()
        );

        scopes.get(getCurrentScope()).add(row);
        return row;
    }

    public boolean existsInCurrentScope(String name) {
        return scopes.get(getCurrentScope())
                .stream()
                .anyMatch(s -> s.getName().equals(name));
    }

    public SymbolRow lookup(String name) {
        for (String scope : scopeStack) {
            for (SymbolRow row : scopes.get(scope)) {
                if (row.getName().equals(name)) {
                    return row;
                }
            }
        }
        return null;
    }

    public List<SymbolRow> getSymbolsInScope(String scope) {
        return scopes.getOrDefault(scope, List.of());
    }

    public Map<String, List<SymbolRow>> getAllScopes() {
        return scopes;
    }

    public void clear() {
        scopes.clear();                // Remove all scopes and their symbols
        scopeStack.clear();            // Reset the scope stack
        enterScope("global");          // Restore the initial global scope
    }

    //Print

    public void print() {
        System.out.println("\n=========== SYMBOL TABLE ===========\n");
        for (Map.Entry<String, List<SymbolRow>> entry : scopes.entrySet()) {
            System.out.println("Scope: " + entry.getKey());
            System.out.println("-".repeat(80));
            entry.getValue().forEach(System.out::println);
            System.out.println();
        }
    }
}
