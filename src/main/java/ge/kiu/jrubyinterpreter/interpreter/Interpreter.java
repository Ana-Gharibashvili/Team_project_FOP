package ge.kiu.jrubyinterpreter.interpreter;

import ge.kiu.jrubyinterpreter.ast.Node;
import ge.kiu.jrubyinterpreter.lexer.Lexer;
import ge.kiu.jrubyinterpreter.lexer.Token;
import ge.kiu.jrubyinterpreter.parser.Parser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Interpreter {
    private static final Logger logger = LogManager.getLogger(Interpreter.class);
    private final Context context;

    public Interpreter() {
        this.context = new Context();
    }

    public Object interpret(String source) {
        try {
            // Lexical analysis
            Lexer lexer = new Lexer(source);
            List<Token> tokens = lexer.tokenize();
            logger.debug("Tokens: {}", tokens);

            // Parsing
            Parser parser = new Parser(tokens, context);
            List<Node> nodes = parser.parseProgram();
            logger.debug("AST: {}", nodes);

            // Execution
            Object result = null;
            for (Node node : nodes) {
                result = node.evaluate();
            }
            return result;

        } catch (Exception e) {
            logger.error("Error while interpreting: {}", e.getMessage());
            throw new RuntimeException("Interpretation error: " + e.getMessage(), e);
        }
    }

    public Context getContext() {
        return context;
    }
} 