package ge.kiu.jrubyinterpreter.ast;

public class PrintNode implements Node {
    private final Node expression;

    public PrintNode(Node expression) {
        this.expression = expression;
    }

    @Override
    public Object evaluate() {
        Object value = expression.evaluate();
        if (value instanceof String) {
            System.out.println(value);
        } else if (value instanceof Number) {
            System.out.println(value);
        } else {
            System.out.println(value);
        }
        return value;
    }
} 