package by.kooks.infoHandling.action;

import by.kooks.infoHandling.chain.TextParser;
import by.kooks.infoHandling.composite.InformationComponent;
import by.kooks.infoHandling.manager.TextManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestTextManager {
    private static String originText;
    private static TextParser textParser;
    private static InformationComponent text;
    private static TextManager textManager;
    private static String expectedTextAfterCollecting;
    private static String expectedTextAfterReplacingLexemes;
    private static String expectedTextAfterSorting;
    private static String expectedTextAfterDeleting;

    @BeforeClass
    public static void initData() {
        textParser = new TextParser();
        textManager = new TextManager();
        originText = "\tIt is a long established fact that a reader will be distracted main. The readable content" +
                " of a page when looking at its layout. The point of using (71-(2*(i--)*(3*(2-1/2*2)-2)-10/2))*++i" +
                " Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content" +
                " here, content here', making it look like readable English.";

        expectedTextAfterCollecting = "\tIt is a long established fact that a reader will be distracted main." +
                " The readable content of a page when looking at its layout. The point of using 408.0 Ipsum is" +
                " that it has a more-or-less normal distribution of letters, as opposed to using 'Content here," +
                " content here', making it look like readable English. \n";

        expectedTextAfterReplacingLexemes = "\tmain.is a long established fact that a reader will be distracted It " +
                "layout.readable content of a page when looking at its The English.point of using 408.0 Ipsum is " +
                "that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content" +
                " here', making it look like readable The \n";

        expectedTextAfterSorting = "\tThe readable content of a page when looking at its layout. \n" +
                "\tIt is a long established fact that a reader will be distracted main. \n" +
                "\tThe point of using 408.0 Ipsum is that it has a more-or-less normal distribution of letters," +
                " as opposed to using 'Content here, content here', making it look like readable English. \n";

        expectedTextAfterDeleting = "\tIt is a long established fact that a reader will be main. The readable content of" +
                " a page when looking at its layout. The point of using 408.0 Ipsum is that it has a more-or-less " +
                "normal distribution of letters, as opposed to using 'Content here, content here', making it look like" +
                " readable English. \n";
    }

    @AfterClass
    public static void removeData() {
        textParser = null;
        textManager = null;
        originText = null;
        expectedTextAfterCollecting = null;
        expectedTextAfterReplacingLexemes = null;
        expectedTextAfterSorting = null;
        expectedTextAfterDeleting = null;
    }

    @Test
    public void collectTextTest() {
        text = textParser.parse(originText);
        String actualTextAfterCollect = textManager.collectText(text);
        Assert.assertEquals(expectedTextAfterCollecting, actualTextAfterCollect);
    }

    @Test
    public void replaceFirstAndLastLexemeTest() {
        text = textParser.parse(originText);
        String actualTextAfterChangeLexeme = textManager.replaceFirstAndLastLexeme(text);
        Assert.assertEquals(expectedTextAfterReplacingLexemes, actualTextAfterChangeLexeme);
    }

    @Test
    public void sortSentenceByAscendingLexemesNumberTest() {
        text = textParser.parse(originText);
        String actualTextAfterSort = textManager.sortSentenceByAscendingLexemesNumber(text);
        Assert.assertEquals(expectedTextAfterSorting, actualTextAfterSort);
    }

    @Test
    public void deleteByLengthAndFirstLetterTest() {
        text = textParser.parse(originText);
        String actualTextAfterDelete = textManager.deleteByLengthAndFirstLetter(text, 'd', 10);
        Assert.assertEquals(expectedTextAfterDeleting, actualTextAfterDelete);
    }
}