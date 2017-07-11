package by.kooks.infoHandling.composite;

import java.util.LinkedList;

public interface InformationComponent {
    void addComponent(InformationComponent informationComponent);
    InformationComponent getChild(int index);
    LinkedList<InformationComponent> getInformationComponentList();
    String getLexeme();
    int getSize();
}
