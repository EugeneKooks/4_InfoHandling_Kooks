package by.kooks.infoHandling.interpreter;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    private static final Logger LOGGER = LogManager.getLogger(Client.class);
    private static final String SPACE_OR_TAB_PATTER = "\\p{Blank}";
    private static final int FIRST_CHAR = 0;
    private ArrayList<AbstractMathExpression> expressionList;
    private double i;
    private double j;

    public Client(double i, double j) {
        this.i = i;
        this.j = j;
        expressionList = new ArrayList<>();
    }

    public String calculate(String expression) {
        for (String lexeme : expression.split(SPACE_OR_TAB_PATTER)) {
            if (lexeme.isEmpty()) {
                LOGGER.log(Level.INFO, "Input lexeme is empty");
                continue;
            }
            char temp = lexeme.charAt(FIRST_CHAR);
            switch (temp) {
                case '+':
                    expressionList.add(new TerminalExpressionPlus());
                    break;
                case '-':
                    expressionList.add(new TerminalExpressionMinus());
                    break;
                case '*':
                    expressionList.add(new TerminalExpressionMultiply());
                    break;
                case '/':
                    expressionList.add(new TerminalExpressionDivide());
                    break;
                case '#':
                    expressionList.add(new TerminalExpressionIncrement());
                    break;
                case '@':
                    expressionList.add(new TerminalExpressionDecrement());
                    break;
                case 'i':
                    expressionList.add(new NonTerminalExpressionNumber(i));
                    break;
                case 'j':
                    expressionList.add(new NonTerminalExpressionNumber(j));
                    break;
                default:
                    Scanner scanner = new Scanner(lexeme);
                    if (scanner.hasNextInt()) {
                        int number = scanner.nextInt();
                        expressionList.add(new NonTerminalExpressionNumber(number));
                    }
            }
        }
        Context context = new Context();
        for (AbstractMathExpression terminal : expressionList) {
            terminal.interpret(context);
        }
        return context.popValue().toString();
    }


}
