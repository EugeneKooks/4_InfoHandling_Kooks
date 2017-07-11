package by.kooks.infoHandling.interpreter;

public class NonTerminalExpressionNumber extends AbstractMathExpression {
    private double number;

    protected NonTerminalExpressionNumber(double number) {
        this.number = number;
    }

    @Override
    public void interpret(Context context) {
        context.pushValue(number);
    }
}
