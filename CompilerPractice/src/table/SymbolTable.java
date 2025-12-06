package table;

import java.util.*;

public class SymbolTable {

    private final List<Map<String, Object>> scopes = new ArrayList<>();

    public SymbolTable() {
        enterScope();
    }

    private Map<String, Object> currentScope() {
        return scopes.get(scopes.size() - 1);
    }

    // Creates a new empty scope
    public Map<String,Object> allocate() {
        Map<String,Object> newScope = new HashMap<>();
        scopes.add(newScope);
        return newScope;
    }

    // Updates existing symbol or creates new in current scope
    public void set_attribute(String name, Object value) {
        currentScope().put(name, value);
    }

    // Guaranteed insert into current scope
    public Object insert(String name, Object value) {
        currentScope().put(name, value);
        return value;
    }

    // Removes entire symbol table (reset to global only)
    public void free() {
        scopes.clear();
        enterScope();
    }

    // Searches through all scopes from innermost to outermost
    public Object lookUp(String name) {
        for (int i = scopes.size() - 1; i >= 0; i--) {
            if (scopes.get(i).containsKey(name))
                return scopes.get(i).get(name);
        }
        return null;
    }

    // Checks if symbol exists (any scope)
    public boolean get_attribute(String name) {
        return lookUp(name) != null;
    }

    // Debug printer
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== SYMBOL TABLE ===\n");
        for (int i = 0; i < scopes.size(); i++)
            sb.append("Scope ").append(i).append(": ").append(scopes.get(i)).append("\n");
        return sb.toString();
    }

    public void enterScope() {
        scopes.add(new HashMap<>());
    }

    public void exitScope() {
        if (scopes.size() > 1)
            scopes.remove(scopes.size() - 1);
    }
}
