package by.kooks.infoHandling.chain;


import by.kooks.infoHandling.composite.InformationComponent;

public class TextParser extends InformationParser {
    private ParagraphParser paragraphParser = new ParagraphParser();

    @Override
    public InformationComponent parse(String data) {
        return paragraphParser.parse(data);
    }
}
