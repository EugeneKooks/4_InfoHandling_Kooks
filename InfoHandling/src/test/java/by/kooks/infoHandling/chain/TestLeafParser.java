package by.kooks.infoHandling.chain;


import by.kooks.infoHandling.composite.InformationComponent;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestLeafParser {
    private LeafParser leafParser;
    private String sentenceData;
    private int expectedSize;
    @Before
    public void initData() {
        leafParser = new LeafParser();
        sentenceData = "It is a (0-5+1/2*(2+5*2-(--j)))*1200 established fact that a reader will be of a page " +
                "when looking at its layout.";
        expectedSize = 19;
    }
    @After
    public void removeData() {
        leafParser = null;
        sentenceData = null;
    }
    @Test
    public void parseTest() {
        InformationComponent sentence = leafParser.parse(sentenceData);
        int actualSize = sentence.getSize();
        Assert.assertEquals(expectedSize, actualSize);
    }
}