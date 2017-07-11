package by.kooks.infoHandling.chain;

import by.kooks.infoHandling.composite.InformationComponent;

public abstract class InformationParser {
    protected abstract InformationComponent parse(String data);
}
