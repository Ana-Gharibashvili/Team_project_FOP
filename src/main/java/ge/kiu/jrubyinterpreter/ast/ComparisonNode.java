package ge.kiu.jrubyinterpreter.ast;

import ge.kiu.jrubyinterpreter.lexer.TokenType;

public class ComparisonNode implements Node {
    private final Node left;
    private final TokenType operator;
    private final Node right;

    public ComparisonNode(Node left, TokenType operator, Node right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    @Override
    public Object evaluate() {
        double leftVal = ((Number) left.evaluate()).doubleValue();
        double rightVal = ((Number) right.evaluate()).doubleValue();

        return switch (operator) {
            case EQUALS -> leftVal == rightVal;
            case NOT_EQUALS -> leftVal != rightVal;
            case GREATER_THAN -> leftVal > rightVal;
            case LESS_THAN -> leftVal < rightVal;
            case GREATER_THAN_EQUALS -> leftVal >= rightVal;
            case LESS_THAN_EQUALS -> leftVal <= rightVal;
            default -> throw new RuntimeException("Unknown comparison operator: " + operator);
        };
    }
} 