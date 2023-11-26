package by.teachmeskills.lesson30.abstractfactory.element.linux;

import by.teachmeskills.lesson30.abstractfactory.element.Label;

public class LinuxLabel implements Label {

    @Override
    public String getText() {
        return "Linux label";
    }
}
