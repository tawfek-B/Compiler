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

    public Scope(String name, Scope parent) {
        this.name = name;
        this.parent = parent;
        if (parent != null) {
            parent.children.add(this);
        }
    }

    public String getName() { return name; }
    public Scope getParent() { return parent; }
    public List<Scope> getChildren() { return children; }

    public boolean define(Symbol symbol) {
        if (symbols.containsKey(symbol.getName())) {
            return false;
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

    // NEW: Helper to remove all children (used by clear)
    public void clearChildren() {
        children.clear();
    }
}