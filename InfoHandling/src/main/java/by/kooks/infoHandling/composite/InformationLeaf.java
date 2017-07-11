package by.kooks.infoHandling.composite;

import java.util.LinkedList;


public class InformationLeaf implements InformationComponent {
    private String leaf;
    public InformationLeaf(String leaf) {
        this.leaf = leaf;
    }
    @Override
    public void addComponent(InformationComponent informationComponent) {
    }
    @Override
    public InformationComponent getChild(int index) {
        throw new UnsupportedOperationException();
    }
    @Override
    public LinkedList<InformationComponent> getInformationComponentList() {
        throw new UnsupportedOperationException();
    }
    @Override
    public String getLexeme() {
        return leaf;
    }
    @Override
    public int getSize() {
        throw new UnsupportedOperationException();
    }
    @Override
    public String toString() {
        return leaf;
    }
}
