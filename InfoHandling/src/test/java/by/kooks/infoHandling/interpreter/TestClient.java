package by.kooks.infoHandling.interpreter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestClient {
    private String expression;
    private String expectedValue;
    private Client client;

    public TestClient(String expectedExpression, String expectedValue) {
        this.expression = expectedExpression;
        this.expectedValue = expectedValue;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"3 5 +", "8.0"},
                {"6 9 3 4 - * +", "-3.0"},
                {"13 i @ +", "17.0"},
                {"5 1 2 * 3 4 5 j @ - 4 + * 3 - * 2 - * 1 - *", "-115.0"},
                {"0 5 - 1 2 / 2 5 2 * + j @ - * + 1200 *", "-4200.0"}
        });
    }

    @Before
    public void initData() {
        client = new Client(5, 10);
    }

    @After
    public void removeData() {
        client = null;
    }

    @Test
    public void calculateTest() {
        String actualValue = client.calculate(expression);
        Assert.assertEquals(expectedValue, actualValue);
    }
}