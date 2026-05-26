// semantics/SemanticError.java
package semantics;

import java.util.ArrayList;
import java.util.List;

public class SemanticError {
    private final List<SemanticIssue> errors = new ArrayList<>();

    public void addError(String message, int line, int column) {
        errors.add(new SemanticIssue(message, line, column));
    }

    public void addWarning(String message, int line, int column) {
        errors.add(new SemanticIssue("WARNING: " + message, line, column));
    }

    public List<SemanticIssue> getErrors() {
        return errors;
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public void print() {
        if (errors.isEmpty()) {
            System.out.println("No semantic errors found.");
            return;
        }
        System.out.println("\n=== Semantic Issues Found ===");
        for (SemanticIssue e : errors) {
            System.out.println(e);
        }
    }
}

