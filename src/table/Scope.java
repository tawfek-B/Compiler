package table;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Scope {
    private final String name;
    private final Scope parent;
    public final Map<String, Symbol> symbols = new HashMap<>();
    private final List<Scope> children = new ArrayList<>();
    private final String fileOrigin;

    public Scope(String name, Scope parent, String fileOrigin) {
        this.name = name;
        this.parent = parent;
        this.fileOrigin = fileOrigin;
        if (parent != null) {
            parent.children.add(this);
        }
    }

    public String getName() { return name; }
    public Scope getParent() { return parent; }
    public List<Scope> getChildren() { return children; }
    public String getFileOrigin() { return fileOrigin; }

    /**
     * Defines a new symbol in this scope.
     * @return true if the symbol was successfully defined.
     *         false if a symbol with the same name already exists in this scope.
     */
    public boolean define(Symbol symbol) {
        if (symbols.containsKey(symbol.getName())) {
            return false; // A symbol with this name is already defined here.
        }
        symbols.put(symbol.getName(), symbol);
        return true;
    }

    public Symbol resolveLocal(String name) {
        return symbols.get(name);
    }

    public Map<String, Symbol> getSymbols() {
        return symbols;
    }

    public void clearChildren() {
        children.clear();
    }
}