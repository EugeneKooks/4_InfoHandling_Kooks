package by.kooks.infoHandling.interpreter;

import java.util.ArrayDeque;

public class Context {
    private ArrayDeque<Double> contextValue = new ArrayDeque<>();

    protected Double popValue() {
        return contextValue.pop();
    }

    protected void pushValue(Double value) {
        contextValue.push(value);
    }
}
