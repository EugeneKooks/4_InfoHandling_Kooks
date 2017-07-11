package by.kooks.infoHandling.manager;

import by.kooks.infoHandling.composite.InformationComponent;

import java.util.LinkedList;

public class TextManager {
    private static final char NEW_LINE_SIGN = '\n';
    private static final char TABULATION_SIGN = '\t';
    private static final char SPACE_SIGN = ' ';
    private static final int FIRST_POSITION = 0;

    public String collectText(InformationComponent text) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < text.getSize(); i++) {
            stringBuilder.append(TABULATION_SIGN);
            for (InformationComponent sentence : text.getChild(i).getInformationComponentList()) {
                for (InformationComponent leaf : sentence.getInformationComponentList()) {
                    String leafData = leaf.getLexeme();
                    stringBuilder.append(leafData).append(SPACE_SIGN);
                }
            }
            stringBuilder.append(NEW_LINE_SIGN);
        }
        return stringBuilder.toString();
    }
    public String replaceFirstAndLastLexeme(InformationComponent text) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < text.getSize(); i++) {
            stringBuilder.append(TABULATION_SIGN);
            for (InformationComponent sentence : text.getChild(i).getInformationComponentList()) {
                LinkedList<InformationComponent> leafs = sentence.getInformationComponentList();
                if (leafs.size() > 1) {
                    InformationComponent firstLexeme = leafs.get(leafs.size() - 1);
                    String firstLexemeData = firstLexeme.getLexeme();
                    stringBuilder.append(firstLexemeData);
                    for (int k = 1; k < leafs.size() - 1; k++) {
                        InformationComponent leaf = leafs.get(k);
                        stringBuilder.append(leaf.getLexeme()).append(SPACE_SIGN);
                    }
                    if (!leafs.isEmpty()) {
                        InformationComponent lastLexeme = leafs.get(FIRST_POSITION);
                        String lastLexemeData = lastLexeme.getLexeme();
                        stringBuilder.append(lastLexemeData).append(SPACE_SIGN);
                    }
                } else {
                    InformationComponent leaf = leafs.get(FIRST_POSITION);
                    stringBuilder.append(leaf.getLexeme()).append(SPACE_SIGN);
                }
            }
            stringBuilder.append(NEW_LINE_SIGN);
        }
        return stringBuilder.toString();
    }

    public String sortSentenceByAscendingLexemesNumber(InformationComponent text) {
        StringBuilder stringBuilder = new StringBuilder();
        LinkedList<InformationComponent> paragraphList = new LinkedList<>();
        for (int i = 0; i < text.getSize(); i++) {
            paragraphList.addAll(text.getChild(i).getInformationComponentList());
        }
        for (int i = 0; i < paragraphList.size(); i++) {
            for (int j = 1; j < paragraphList.size() - i; j++) {
                if (paragraphList.get(j - 1).getSize() > paragraphList.get(j).getSize()) {
                    InformationComponent tmp = paragraphList.remove(j - 1);
                    paragraphList.add(j, tmp);
                }
            }
        }
        for (InformationComponent paragraph : paragraphList) {
            stringBuilder.append(TABULATION_SIGN);
            for (InformationComponent leaf : paragraph.getInformationComponentList()) {
                stringBuilder.append(leaf.getLexeme()).append(SPACE_SIGN);
            }
            stringBuilder.append(NEW_LINE_SIGN);
        }
        return stringBuilder.toString();
    }

    public String deleteByLengthAndFirstLetter(InformationComponent text, char letter, int wordSize) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < text.getSize(); i++) {
            stringBuilder.append(TABULATION_SIGN);
            for (InformationComponent sentence : text.getChild(i).getInformationComponentList()) {
                for (InformationComponent leaf : sentence.getInformationComponentList()) {
                    String leafData = leaf.getLexeme().trim();
                    if (!(leafData.length() == wordSize && leafData.charAt(FIRST_POSITION) == letter)) {
                        stringBuilder.append(leafData).append(SPACE_SIGN);
                    }
                }
            }
            stringBuilder.append(NEW_LINE_SIGN);
        }
        return stringBuilder.toString();
    }
}