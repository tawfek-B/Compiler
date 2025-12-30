package table;

public class SymbolRow {

    private final String name;
    private final String type;
    private final String value;
    private final int line;
    private final int column;
    private final String scope;

    public SymbolRow(String name, String type, String value, int line, int column, String scope) {
        this.name = name;
        this.type = type;
        this.value = value;
        this.line = line;
        this.column = column;
        this.scope = scope;
    }

    public String getName() { return name; }
    public String getType() { return type; }
    public String getValue() { return value; }
    public int getLine() { return line; }
    public int getColumn() { return column; }
    public String getScope() { return scope; }

    public String getQualifiedName() {
        return scope + "." + name;
    }

    @Override
    public String toString() {
        return String.format(
                "%-15s %-10s %-10s (line %d, col %d) [scope=%s]",
                name,
                type != null ? type : "unknown",
                value != null ? value : "null",
                line,
                column,
                scope
        );
    }
}
