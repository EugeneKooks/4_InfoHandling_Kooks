package by.kooks.infoHandling.interpreter;

public class TerminalExpressionPlus extends AbstractMathExpression {
    @Override
    protected void interpret(Context context) {
        double secondNumber = context.popValue();
        double firstNumber = context.popValue();
        context.pushValue(firstNumber + secondNumber);
    }
}