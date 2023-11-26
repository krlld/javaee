package by.teachmeskills.lesson30.abstractfactory.factory;

import by.teachmeskills.lesson30.abstractfactory.element.Button;
import by.teachmeskills.lesson30.abstractfactory.element.CheckBox;
import by.teachmeskills.lesson30.abstractfactory.element.Label;
import by.teachmeskills.lesson30.abstractfactory.element.macos.MacOSButton;
import by.teachmeskills.lesson30.abstractfactory.element.macos.MacOSCheckBox;
import by.teachmeskills.lesson30.abstractfactory.element.macos.MacOSLabel;

public class MacOSElementFactory implements ElementFactory {

    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacOSCheckBox();
    }

    @Override
    public Label createLabel() {
        return new MacOSLabel();
    }
}
