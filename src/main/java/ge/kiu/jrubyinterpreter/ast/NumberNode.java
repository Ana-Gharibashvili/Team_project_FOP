package ge.kiu.jrubyinterpreter.ast;

public class NumberNode implements Node {
    private final double value;

    public NumberNode(double value) {
        this.value = value;
    }

    @Override
    public Object evaluate() {
        return value;
    }
} 