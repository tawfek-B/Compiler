// semantics/FlaskBuiltins.java
package semantics;

import table.*;
import ast.python.*;

public class FlaskBuiltins {

    public static void populate(SymbolTable symbolTable) {
        String[][] builtins = {
                {"Flask", "FUNCTION"},
                {"render_template", "FUNCTION"},
                {"url_for", "FUNCTION"},
                {"flash", "FUNCTION"},
                {"redirect", "FUNCTION"},
                {"request", "OBJECT"},
                {"app", "OBJECT"},
                {"jsonify", "FUNCTION"},
                {"session", "OBJECT"}
        };

        for (String[] b : builtins) {
            Symbol s = new Symbol(b[0], Type.valueOf(b[1]), SymbolKind.BUILTIN, 0, 0);
            symbolTable.define(s);
        }
    }
}