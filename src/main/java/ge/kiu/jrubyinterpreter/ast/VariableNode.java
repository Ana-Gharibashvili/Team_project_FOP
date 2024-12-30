package ge.kiu.jrubyinterpreter.ast;

import ge.kiu.jrubyinterpreter.interpreter.Context;

public class VariableNode implements Node {
    private final String name;
    private final Context context;

    public VariableNode(String name, Context context) {
        this.name = name;
        this.context = context;
    }

    @Override
    public Object evaluate() {
        return context.getVariable(name);
    }
} 