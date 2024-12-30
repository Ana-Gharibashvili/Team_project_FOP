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
        // TODO - implement logic for if statement and return appropriate Node element
        return null;
    }

    private Node whileStatement() {
        // TODO - implement logic for while statement and return appropriate Node element
        return null;
    }

    private Node comparison() {
        // TODO - implement logic for comparison and return appropriate Node element
        return null;
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
        // TODO - implement logic for term statement and return appropriate Node element
        return null;
    }

    private Node factor() {
        // TODO - implement logic factor statement and return appropriate Node element
        return null;
    }

    private Node printStatement() {
        // TODO - implement logic for print statement and return appropriate Node element
        return null;
    }

    private Node readStatement() {
        // TODO - implement logic for read statement and return appropriate Node element
        return null;
    }

    private Node assignmentOrExpression() {
        // TODO - implement logic for assignment and expression and return appropriate Node element
        return null;
    }

    private Token current() {
        return tokens.get(position);
    }
} 