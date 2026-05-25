package table;

import java.util.List;

public class FunctionSymbol extends Symbol {

    private final List<Type> paramTypes;

    public FunctionSymbol(String name, Type returnType, List<Type> paramTypes, int line, int column) {
        super(name, returnType, SymbolKind.FUNCTION, line, column);
        this.paramTypes = paramTypes;
    }

    public List<Type> getParamTypes(){
        return paramTypes;
    }

    public int getParamCount(){
        return paramTypes.size();
    }
}
