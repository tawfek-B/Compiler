package table;

public class Symbol {

    protected final String name;
    protected final Type type;
    protected final SymbolKind kind;
    protected final int line;
    protected final int column;
//    protected final String scope;

    public Symbol(String name, Type type,SymbolKind kind, int line, int column) {
        this.name = name;
        this.type = type;
        this.kind = kind;
        this.line = line;
        this.column = column;
//        this.scope = scope;
    }


    public String getName() { return name; }
    public Type getType() { return type; }
    public SymbolKind getKind() { return kind; }
    public int getLine() { return line; }
    public int getColumn() { return column; }
//    public String getScope() { return scope; }
//
//    public String getQualifiedName() {
//        return scope + "." + name;
//    }

    @Override
    public String toString() {
        return String.format(
                "%-15s %-10s %-10s (line %d, col %d)",
                name,
                type != null ? type : "UNKNOWN",
                kind,
                line,
                column
//                scope
        );
    }


}
