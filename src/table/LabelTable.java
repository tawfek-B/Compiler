package table;

import java.util.HashMap;
import java.util.Map;

public class LabelTable {

    private final Map<Symbol, String> labels = new HashMap<>();
    private int counter = 0;
    private final Map<String,String> blockLabels = new HashMap<>();

    public String generateLabel(Symbol symbol) {
        return labels.computeIfAbsent(
                symbol, s -> "L" + counter++
        );
    }

    public String generateAnonymousLabel() {
        String label = "L" + counter++;
        return label;
    }

    public String generateBlockLabel(String blockName) {
        return blockLabels.computeIfAbsent(blockName, k->"BLOCK_"+ k +"_"+ counter ++);
    }

    public String getLabel(Symbol symbol){
        return labels.get(symbol);
    }

    public void clear() {
        labels.clear();
        counter = 0;
    }

    public void print() {
        System.out.println("\n=========== LABEL TABLE ===========\n");
        labels.forEach((k, v) ->
                System.out.println(k.getName() + " -> " + v)
        );
    }
}
