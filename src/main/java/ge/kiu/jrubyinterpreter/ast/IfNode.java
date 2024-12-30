package ge.kiu.jrubyinterpreter.ast;

import java.util.List;

public class IfNode implements Node {
    private final Node condition;
    private final List<Node> thenBranch;
    private final List<Node> elseBranch;

    public IfNode(Node condition, List<Node> thenBranch, List<Node> elseBranch) {
        this.condition = condition;
        this.thenBranch = thenBranch;
        this.elseBranch = elseBranch;
    }

    @Override
    public Object evaluate() {
        boolean conditionResult = (Boolean) condition.evaluate();
        Object result = null;

        if (conditionResult) {
            for (Node node : thenBranch) {
                result = node.evaluate();
            }
        } else if (elseBranch != null) {
            for (Node node : elseBranch) {
                result = node.evaluate();
            }
        }

        return result;
    }
} 