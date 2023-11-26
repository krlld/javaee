package by.teachmeskills.lesson30.abstractfactory.factory;

import by.teachmeskills.lesson30.abstractfactory.element.Button;
import by.teachmeskills.lesson30.abstractfactory.element.CheckBox;
import by.teachmeskills.lesson30.abstractfactory.element.Label;
import by.teachmeskills.lesson30.abstractfactory.element.windows.WindowsButton;
import by.teachmeskills.lesson30.abstractfactory.element.windows.WindowsCheckBox;
import by.teachmeskills.lesson30.abstractfactory.element.windows.WindowsLabel;

public class WindowsElementFactory implements ElementFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowsCheckBox();
    }

    @Override
    public Label createLabel() {
        return new WindowsLabel();
    }
}
