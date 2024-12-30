package ge.kiu.jrubyinterpreter.ast;

import java.util.List;

public class WhileNode implements Node {
    private final Node condition;
    private final List<Node> body;

    public WhileNode(Node condition, List<Node> body) {
        this.condition = condition;
        this.body = body;
    }

    @Override
    public Object evaluate() {
        Object result = null;
        while ((Boolean) condition.evaluate()) {
            for (Node node : body) {
                result = node.evaluate();
            }
        }
        return result;
    }
} 