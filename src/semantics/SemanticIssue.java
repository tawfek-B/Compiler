package semantics;

class SemanticIssue {
    String message;
    int line, column;

    SemanticIssue(String message, int line, int column) {
        this.message = message;
        this.line = line;
        this.column = column;
    }

    @Override
    public String toString() {
        return String.format("Line %d:%d - %s", line, column, message);
    }
}