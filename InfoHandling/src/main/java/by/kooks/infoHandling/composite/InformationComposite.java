package by.kooks.infoHandling.composite;

import java.util.LinkedList;

public class InformationComposite implements InformationComponent {

    private LinkedList<InformationComponent> components = new LinkedList<>();

    @Override
    public void addComponent(InformationComponent informationComponent) {
        components.add(informationComponent);
    }

    @Override
    public InformationComponent getChild(int index) {
        return components.get(index);
    }

    @Override
    public LinkedList<InformationComponent> getInformationComponentList() {
        return components;
    }

    @Override
    public String getLexeme() {
        throw new UnsupportedOperationException();
    }


    @Override
    public int getSize() {
        return components.size();
    }
}