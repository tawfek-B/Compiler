package table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scope {
    private final String name;
    private final Scope parent;
    private final List<Scope> children = new ArrayList<>();
    private final Map<String, Symbol> symbols = new HashMap<>();

    public Scope(String name, Scope parent) {
        this.name = name;
        this.parent = parent;
    }

    public void addChild(Scope child) {
        children.add(child);
    }

    public List<Scope> getChildren() {
        return children;
    }

    public Scope getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }

    public Map<String, Symbol> getSymbols() {
        return symbols;
    }


    public boolean define(Symbol symbol){
        if(symbols.containsKey(symbol.getName())){
            return false;

        }

        symbols.put(symbol.getName(),symbol);
        return true;
    }

    public Symbol resolveLocal(String name){
        return symbols.get(name);
    }

}
