package table;

import java.util.HashMap;
import java.util.Map;

public class LabelTable {

    private final Map<String, String> labels = new HashMap<>();
    private int counter = 0;

    public String generateLabel(SymbolRow symbol) {
        String key = symbol.getQualifiedName();
        return labels.computeIfAbsent(
                key,
                k -> "L" + counter++
        );
    }

    public String generateAnonymousLabel() {
        String label = "L" + counter++;
        labels.put(label, label);
        return label;
    }

    public String getLabel(SymbolRow symbol) {
        return labels.get(symbol.getQualifiedName());
    }

    public void print() {
        System.out.println("\n=========== LABEL TABLE ===========\n");
        labels.forEach((k, v) ->
                System.out.println(k + " -> " + v)
        );
    }
}
