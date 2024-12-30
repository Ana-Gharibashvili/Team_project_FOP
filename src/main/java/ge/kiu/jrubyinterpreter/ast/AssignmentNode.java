package ge.kiu.jrubyinterpreter.ast;

import ge.kiu.jrubyinterpreter.interpreter.Context;

public class AssignmentNode implements Node {
    private final String name;
    private final Node value;
    private final Context context;

    public AssignmentNode(String name, Node value, Context context) {
        this.name = name;
        this.value = value;
        this.context = context;
    }

    @Override
    public Object evaluate() {
        Object result = value.evaluate();
        context.setVariable(name, result);
        return result;
    }
} 