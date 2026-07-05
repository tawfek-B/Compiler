package table;

public class Symbol {

    public final String name;
    public Type type;
    protected final SymbolKind kind;
    protected final int line;
    protected final int column;
    public final String fileOrigin;  // NEW: which file this symbol came from
    public SymbolOccurrences symbolOccurrences = new SymbolOccurrences();

    public Symbol(String name, Type type, SymbolKind kind, int line, int column, String fileOrigin) {
        this.name = name;
        this.type = type;
        this.kind = kind;
        this.line = line;
        this.column = column;
        this.fileOrigin = fileOrigin != null ? fileOrigin : "unknown";
    }

    // Backward-compatible constructor (defaults to unknown file)
    public Symbol(String name, Type type, SymbolKind kind, int line, int column) {
        this(name, type, kind, line, column, "unknown");
    }

    public Type setType(Type newType) {
        type = newType;
        return type;
    }

    public String getName() { return name; }
    public Type getType() { return type; }
    public SymbolKind getKind() { return kind; }
    public int getLine() { return line; }
    public int getColumn() { return column; }
    public String getFileOrigin() { return fileOrigin; }  // NEW

    @Override
    public String toString() {
        return String.format(
                "%-15s %-10s %-10s %-20s (line %d, col %d)",
                name,
                type != null ? type : "UNKNOWN",
                kind,
                fileOrigin,
                line,
                column
        );
    }
}