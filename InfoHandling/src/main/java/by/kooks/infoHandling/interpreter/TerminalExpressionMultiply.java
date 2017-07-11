package by.kooks.infoHandling.interpreter;

public class TerminalExpressionMultiply extends AbstractMathExpression {
    @Override
    protected void interpret(Context context) {
        double secondNumber = context.popValue();
        double firstNumber = context.popValue();
        context.pushValue(firstNumber * secondNumber);
    }
}