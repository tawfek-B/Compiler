package ast.core;

import java.util.ArrayList;
import java.util.List;

public class DictNode extends ASTNode{

    public List<DictEntryNode> entries = new ArrayList<>();

    public DictNode(int line){
        super("Dict",line);
    }

    public void addEntry(DictEntryNode entry){
        entries.add(entry);
        add(entry);
    }

}
