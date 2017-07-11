package by.kooks.infoHandling.chain;

import by.kooks.infoHandling.composite.InformationComponent;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestSentenceParser {
    private SentenceParser sentenceParser;
    private String paragraphData;
    private int expectedSize;

    @Before
    public void initData() {
        sentenceParser = new SentenceParser();
        paragraphData = "It is a long established fact that a reader will be distracted main by the readable " +
                "content of a page when looking at its layout. The point of using (71-(2*i--*(3*(2-1/2*2)-2)" +
                "-10/2))*++i. Ipsum is that it has a more-or-less normal distribution of letters, as opposed to" +
                " using 'Content here, content here', making it look like readable English.";
        expectedSize = 3;
    }

    @After
    public void removeInit() {
        sentenceParser = null;
        paragraphData = null;
    }

    @Test
    public void parseTest() {
        InformationComponent paragraph = sentenceParser.parse(paragraphData);
        int actualSize = paragraph.getSize();
        Assert.assertEquals(expectedSize, actualSize);
    }
}