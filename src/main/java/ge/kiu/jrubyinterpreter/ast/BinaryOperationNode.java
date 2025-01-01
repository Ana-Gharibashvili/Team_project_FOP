package ge.kiu.jrubyinterpreter.ast;

import ge.kiu.jrubyinterpreter.lexer.TokenType;

public class BinaryOperationNode implements Node {
    private final Node left;
    private final TokenType operator;
    private final Node right;

    public BinaryOperationNode(Node left, TokenType operator, Node right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    @Override
    public Object evaluate() {
        double leftVal = ((Number) left.evaluate()).doubleValue();
        double rightVal = ((Number) right.evaluate()).doubleValue();

        return switch (operator) {
            case PLUS -> leftVal + rightVal;
            case MINUS -> leftVal - rightVal;
            case MULTIPLY -> leftVal * rightVal;
            case DIVIDE -> {
                if (rightVal == 0) {
                    throw new RuntimeException("Division by zero");
                }
                yield Math.floor(leftVal / rightVal);
            }
            case MODULO -> {
                if (rightVal == 0) {
                    throw new RuntimeException("Modulo by zero");
                }
                yield leftVal % rightVal;
            }
            default -> throw new RuntimeException("Unknown operator: " + operator);
        };
    }
} 