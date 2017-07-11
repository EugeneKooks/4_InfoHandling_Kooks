package by.kooks.infoHandling.chain;

import by.kooks.infoHandling.composite.InformationComponent;
import by.kooks.infoHandling.composite.InformationComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ParagraphParser extends InformationParser {
    private static final String PARAGRAPH_PATTERN = ".+\n";
    private SentenceParser sentenceParser = new SentenceParser();

    @Override
    protected InformationComponent parse(String textData) {
        InformationComposite text = new InformationComposite();
        Pattern paragraphPattern = Pattern.compile(PARAGRAPH_PATTERN);
        Matcher paragraphMatcher = paragraphPattern.matcher(textData);

        while (paragraphMatcher.find()) {
            InformationComponent paragraph = sentenceParser.parse(paragraphMatcher.group());
            text.addComponent(paragraph);
        }
        if (!textData.isEmpty()) {
            InformationComponent paragraph = sentenceParser.parse(textData);
            text.addComponent(paragraph);
        }
        return text;
    }
}
