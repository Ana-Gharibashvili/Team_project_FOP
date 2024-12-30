package ge.kiu.jrubyinterpreter.ast;

public class StringNode implements Node {
    private final String value;

    public StringNode(String value) {
        this.value = value;
    }

    @Override
    public Object evaluate() {
        return value;
    }
} 