package by.kooks.infoHandling.chain;


import by.kooks.infoHandling.composite.InformationComponent;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestParagraphParser {
    private ParagraphParser paragraphParser;
    private String textData;
    private int expectedSize;

    @Before
    public void initData() {
        paragraphParser = new ParagraphParser();
        textData = "It is a (0-5+1/2*(2+5*2-(--j)))*1200 established fact that a reader will be of a page when " +
                "looking at its layout.\n" + "It is a long established fact that a reader will be distracted main.\n" +
                "The readable content of a page when looking at its layout.\n";
        expectedSize = 4;
    }

    @After
    public void removeInit() {
        paragraphParser = null;
        textData = null;
    }

    @Test
    public void parseTest() {
        InformationComponent text = paragraphParser.parse(textData);
        int actualSize = text.getSize();
        Assert.assertEquals(expectedSize, actualSize);
    }
}
