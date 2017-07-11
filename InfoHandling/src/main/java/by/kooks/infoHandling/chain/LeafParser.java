package by.kooks.infoHandling.chain;

import by.kooks.infoHandling.manager.ReversePolishNotationAction;
import by.kooks.infoHandling.composite.InformationComponent;
import by.kooks.infoHandling.composite.InformationComposite;
import by.kooks.infoHandling.composite.InformationLeaf;
import by.kooks.infoHandling.interpreter.Client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LeafParser extends InformationParser {
    private static final String LEXEME_PATTERN = "(\\w|\\+|-|\\*|/|\\(|\\)|'|,|:)+[.\\p{Blank}]";
    private static final String ARITHMETIC_EXPRESSION_PATTERN = "(\\d|\\+|-|\\*|/|\\(|\\)|i|j)+\\p{Blank}?";

    @Override
    protected InformationComponent parse(String sentenceData) {
        Client client = new Client(5, 10);
        Pattern pattern = Pattern.compile(LEXEME_PATTERN);
        Matcher matcher = pattern.matcher(sentenceData);
        InformationComposite sentence = new InformationComposite();
        while (matcher.find()) {
            String leaf = matcher.group();
            Pattern arithmeticPattern = Pattern.compile(ARITHMETIC_EXPRESSION_PATTERN);
            Matcher arithmeticMatcher = arithmeticPattern.matcher(leaf);
            boolean isArithmetic = arithmeticMatcher.matches();
            if (isArithmetic) {
                String reverseExpression = new ReversePolishNotationAction().reverseExpression(leaf);
                leaf = client.calculate(reverseExpression);
            }
            InformationLeaf textLeaf = new InformationLeaf(leaf.trim());
            sentence.addComponent(textLeaf);
        }
        return sentence;
    }
}