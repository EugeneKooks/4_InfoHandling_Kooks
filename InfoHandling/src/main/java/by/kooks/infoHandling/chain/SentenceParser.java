package by.kooks.infoHandling.chain;

import by.kooks.infoHandling.composite.InformationComponent;
import by.kooks.infoHandling.composite.InformationComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class SentenceParser extends InformationParser {
    private LeafParser leafParser = new LeafParser();
    private static final String SENTENCE_PATTERN = "\\p{Blank}+[^.!?]*[.!?]";

    @Override
    protected InformationComponent parse(String paragraphData) {
        InformationComposite paragraph = new InformationComposite();
        Pattern sentencePattern = Pattern.compile(SENTENCE_PATTERN);
        Matcher sentenceMatcher = sentencePattern.matcher(paragraphData);

        while (sentenceMatcher.find()) {
            InformationComponent sentence = leafParser.parse(sentenceMatcher.group());
            paragraph.addComponent(sentence);
        }
        return paragraph;
    }
}
