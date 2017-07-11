package by.kooks.infoHandling.manager;

import java.util.ArrayDeque;
import java.util.HashMap;

public class ReversePolishNotationAction {
    private static final char WHITESPACE = ' ';
    private static final String DECREMENT_SIGN = "--";
    private static final String DECREMENT_NEW_SIGN = "@";
    private static final String INCREMENT_SIGN = "++";
    private static final String INCREMENT_NEW_SIGN = "#";
    private static final int NEXT_CHAR = 1;
    private static HashMap<Character, Integer> operationPriority;

    static {
        operationPriority = new HashMap<>();
        operationPriority.put('(', 0);
        operationPriority.put(')', 0);
        operationPriority.put('+', 1);
        operationPriority.put('-', 1);
        operationPriority.put('*', 2);
        operationPriority.put('/', 2);
        operationPriority.put('@', 3);
        operationPriority.put('#', 3);
    }

    public String reverseExpression(String expression) {
        expression = expression.replace(DECREMENT_SIGN, DECREMENT_NEW_SIGN);
        expression = expression.replace(INCREMENT_SIGN, INCREMENT_NEW_SIGN);
        ArrayDeque<Character> operationStack = new ArrayDeque<>();
        StringBuilder postfixExpression = new StringBuilder();
        for (int i = 0; i < expression.length() - 1; i++) {
            char token = expression.charAt(i);
            if (Character.isDigit(token)) {
                postfixExpression.append(token);
                if (!Character.isDigit(expression.charAt(i + NEXT_CHAR))) {
                    postfixExpression.append(WHITESPACE);
                }
            } else {
                if (token == 'i' || token == 'j') {
                    postfixExpression.append(token).append(WHITESPACE);
                }
            }
            switch (token) {
                case '(':
                    operationStack.push(token);
                    break;
                case ')':
                    while (!operationStack.isEmpty() && operationStack.getFirst() != '(') {
                        postfixExpression.append(operationStack.pop()).append(WHITESPACE);
                    }
                    if (!operationStack.isEmpty() && operationStack.getFirst() == '(') {
                        operationStack.pop();
                    }
                    break;
                case '+':
                    while (!operationStack.isEmpty() && operationPriority.get('+') <= operationPriority.get
                            (operationStack.getFirst())) {
                        postfixExpression.append(operationStack.pop()).append(WHITESPACE);
                    }
                    operationStack.push(token);
                    break;
                case '-':
                    while (!operationStack.isEmpty() && operationPriority.get('-') <= operationPriority.get(operationStack.getFirst())) {
                        postfixExpression.append(operationStack.pop()).append(WHITESPACE);
                    }
                    operationStack.push(token);
                    break;
                case '*':
                    while (!operationStack.isEmpty() && operationPriority.get('*') <= operationPriority.get(operationStack.getFirst())) {
                        postfixExpression.append(operationStack.pop()).append(WHITESPACE);
                    }
                    operationStack.push(token);
                    break;
                case '/':
                    while (!operationStack.isEmpty() && operationPriority.get('/') <= operationPriority.get(operationStack.getFirst())) {
                        postfixExpression.append(operationStack.pop()).append(WHITESPACE);
                    }
                    operationStack.push(token);
                    break;
                case '@':
                    while (!operationStack.isEmpty() && operationPriority.get('@') <= operationPriority.get(operationStack.getFirst())) {
                        postfixExpression.append(operationStack.pop()).append(WHITESPACE);
                    }
                    operationStack.push(token);
                    break;
                case '#':
                    while (!operationStack.isEmpty() && operationPriority.get('#') <= operationPriority.get(operationStack.getFirst())) {
                        postfixExpression.append(operationStack.pop()).append(WHITESPACE);
                    }
                    operationStack.push(token);
                    break;
            }
        }
        while (!operationStack.isEmpty() && operationStack.getFirst() != '(') {
            postfixExpression.append(operationStack.pop()).append(WHITESPACE);
        }
        return postfixExpression.toString();
    }
}
