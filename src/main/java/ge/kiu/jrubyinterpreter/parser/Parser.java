package ge.kiu.jrubyinterpreter.parser;

import ge.kiu.jrubyinterpreter.ast.*;
import ge.kiu.jrubyinterpreter.interpreter.Context;
import ge.kiu.jrubyinterpreter.lexer.Token;
import ge.kiu.jrubyinterpreter.lexer.TokenType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    private static final Logger logger = LogManager.getLogger(Parser.class);
    private final List<Token> tokens;
    private int position;
    private final Context context;

    public Parser(List<Token> tokens, Context context) {
        this.tokens = tokens;
        this.position = 0;
        this.context = context;
    }

    public List<Node> parseProgram() {
        List<Node> nodes = new ArrayList<>();
        while (position < tokens.size() && current().getType() != TokenType.EOF) {
            nodes.add(statement());
            if (position < tokens.size() && current().getType() == TokenType.NEWLINE) {
                position++;
            }
        }
        return nodes;
    }

    private Node statement() {
        TokenType type = current().getType();
        return switch (type) {
            case IF -> ifStatement();
            case WHILE -> whileStatement();
            case PRINT -> printStatement();
            case READ -> readStatement();
            case IDENTIFIER -> assignmentOrExpression();
            default -> expression();
        };
    }

    private Node ifStatement() {
        position++; // Skip 'if'
        Node condition = comparison();
        List<Node> thenBranch = new ArrayList<>();
        List<Node> elseBranch = null;

        while (position < tokens.size() &&
                current().getType() != TokenType.END &&
                current().getType() != TokenType.ELSE) {
            if (current().getType() == TokenType.NEWLINE) {
                position++;
                continue;
            }
            thenBranch.add(statement());
        }

        if (position < tokens.size() && current().getType() == TokenType.ELSE) {
            position++; // Skip 'else'
            elseBranch = new ArrayList<>();
            while (position < tokens.size() && current().getType() != TokenType.END) {
                if (current().getType() == TokenType.NEWLINE) {
                    position++;
                    continue;
                }
                elseBranch.add(statement());
            }
        }

        if (position >= tokens.size() || current().getType() != TokenType.END) {
            throw new RuntimeException("Expected 'end' keyword");
        }
        position++; // Skip 'end'

        return new IfNode(condition, thenBranch, elseBranch);
    }

    private Node whileStatement() {
        position++; // Skip 'while'
        Node condition = comparison();
        List<Node> body = new ArrayList<>();

        while (position < tokens.size() && current().getType() != TokenType.END) {
            if (current().getType() == TokenType.NEWLINE) {
                position++;
                continue;
            }
            body.add(statement());
        }

        if (position >= tokens.size() || current().getType() != TokenType.END) {
            throw new RuntimeException("Expected 'end' keyword");
        }
        position++; // Skip 'end'

        return new WhileNode(condition, body);
    }

    private Node comparison() {
        Node node = expression();

        while (position < tokens.size() && isComparisonOperator(current().getType())) {
            Token operator = current();
            position++;
            Node right = expression();
            node = new ComparisonNode(node, operator.getType(), right);
        }

        return node;
    }

    private boolean isComparisonOperator(TokenType type) {
        return type == TokenType.EQUALS ||
                type == TokenType.NOT_EQUALS ||
                type == TokenType.GREATER_THAN ||
                type == TokenType.LESS_THAN ||
                type == TokenType.GREATER_THAN_EQUALS ||
                type == TokenType.LESS_THAN_EQUALS;
    }

    private Node expression() {
        Node node = term();

        while (position < tokens.size() &&
                (current().getType() == TokenType.PLUS ||
                        current().getType() == TokenType.MINUS)) {
            Token operator = current();
            position++;
            Node right = term();
            node = new BinaryOperationNode(node, operator.getType(), right);
        }

        return node;
    }

    private Node term() {
        Node node = factor();

        while (position < tokens.size() &&
                (current().getType() == TokenType.MULTIPLY ||
                        current().getType() == TokenType.DIVIDE ||
                        current().getType() == TokenType.MODULO)) {
            Token operator = current();
            position++;
            Node right = factor();
            node = new BinaryOperationNode(node, operator.getType(), right);
        }

        return node;
    }

    private Node factor() {
        Token token = current();
        position++;

        return switch (token.getType()) {
            case NUMBER -> new NumberNode(Double.parseDouble(token.getValue()));
            case STRING -> new StringNode(token.getValue());
            case READ -> new ReadNode();
            case IDENTIFIER -> {
                if (position < tokens.size() && current().getType() == TokenType.ASSIGN) {
                    position++;
                    Node value = expression();
                    yield new AssignmentNode(token.getValue(), value, context);
                }
                yield new VariableNode(token.getValue(), context);
            }
            case LEFT_PAREN -> {
                Node node = expression();
                if (position >= tokens.size() || current().getType() != TokenType.RIGHT_PAREN) {
                    throw new RuntimeException("Expected ')'");
                }
                position++;
                yield node;
            }
            default -> throw new RuntimeException("Unexpected token: " + token);
        };
    }

    private Node printStatement() {
        position++; // Skip 'print'
        return new PrintNode(expression());
    }

    private Node readStatement() {
        position++; // Skip 'read'
        return new ReadNode();
    }

    private Node assignmentOrExpression() {
        Token token = current();
        position++;

        if (position < tokens.size() && current().getType() == TokenType.ASSIGN) {
            position++;
            Node value = expression();
            return new AssignmentNode(token.getValue(), value, context);
        }

        position--; // Go back if it's not an assignment
        return expression();
    }

    private Token current() {
        return tokens.get(position);
    }
} 