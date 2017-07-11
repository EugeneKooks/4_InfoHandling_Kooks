package by.kooks.infoHandling.interpreter;

public class TerminalExpressionDecrement extends AbstractMathExpression {
    @Override
    protected void interpret(Context context) {
        context.pushValue(context.popValue() - 1);
    }
}