package by.kooks.infoHandling.starter;

import by.kooks.infoHandling.action.TestReversePolishNotationAction;
import by.kooks.infoHandling.action.TestTextManager;
import by.kooks.infoHandling.chain.TestLeafParser;
import by.kooks.infoHandling.chain.TestSentenceParser;
import by.kooks.infoHandling.interpreter.TestClient;
import by.kooks.infoHandling.reader.TestInformationReader;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Suite.SuiteClasses({
        TestInformationReader.class,
        TestLeafParser.class,
        TestSentenceParser.class,
        TestLeafParser.class,
        TestReversePolishNotationAction.class,
        TestClient.class,
        TestTextManager.class
})
@RunWith(Suite.class)
public class TestingStarter {
}