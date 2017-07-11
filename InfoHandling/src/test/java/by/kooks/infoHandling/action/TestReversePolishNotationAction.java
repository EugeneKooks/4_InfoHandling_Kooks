package by.kooks.infoHandling.action;

import by.kooks.infoHandling.manager.ReversePolishNotationAction;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestReversePolishNotationAction {
    private ReversePolishNotationAction reversePolishNotationAction;
    private String expression;
    private String expectedExpression;

    public TestReversePolishNotationAction(String expression, String reversePolishExpression) {
        this.expression = expression;
        this.expectedExpression = reversePolishExpression;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"2+3*6 ", "2 3 6 * + "},
                {"(0-5+1/2*(2+5*2-(--j)))*1200 ", "0 5 - 1 2 / 2 5 2 * + j @ - * + 1200 * "},
                {"13+(i--) ", "13 i @ + "},
                {"5*(1*2*(3*(4*(5-(--j)+4)-3)-2)-1) ", "5 1 2 * 3 4 5 j @ - 4 + * 3 - * 2 - * 1 - * "},
                {"6+9*(3-4) ", "6 9 3 4 - * + "}
        });
    }

    @Before
    public void initData() {
        reversePolishNotationAction = new ReversePolishNotationAction();
    }

    @After
    public void removeData() {
        reversePolishNotationAction = null;
    }

    @Test
    public void reverseExpressionTest() {
        String actualExpression = reversePolishNotationAction.reverseExpression(expression);
        Assert.assertEquals(expectedExpression, actualExpression);
    }
}