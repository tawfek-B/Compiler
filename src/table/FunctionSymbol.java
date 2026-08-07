package table;

import java.util.List;

public class FunctionSymbol extends Symbol {
    private final List<Type> paramTypes;

    public FunctionSymbol(String name, Type type, List<Type> paramTypes,
                          int line, int column, String fileOrigin) {
        super(name, type, SymbolKind.FUNCTION, line, column, fileOrigin);
        this.paramTypes = paramTypes;
    }

    public FunctionSymbol(String name, Type type, List<Type> paramTypes,
                          int line, int column) {
        this(name, type, paramTypes, line, column, "unknown");
    }

    public List<Type> getParamTypes() {
        return paramTypes;
    }

    @Override
    public String toString() {
        return String.format(
                "%-15s %-10s %-10s %-20s (line %d, col %d)",
                getName(),
                getType() != null ? getType() : "UNKNOWN",
                getKind(),
                getFileOrigin(),
                getLine(),
                getColumn()
        );
    }
}