package by.kooks.infoHandling.interpreter;

public class TerminalExpressionIncrement extends AbstractMathExpression {
    @Override
    protected void interpret(Context context) {
        context.pushValue(context.popValue() + 1);
    }
}
