package by.teachmeskills.lesson30.abstractfactory.factory;

import by.teachmeskills.lesson30.abstractfactory.element.Button;
import by.teachmeskills.lesson30.abstractfactory.element.CheckBox;
import by.teachmeskills.lesson30.abstractfactory.element.Label;
import by.teachmeskills.lesson30.abstractfactory.element.linux.LinuxButton;
import by.teachmeskills.lesson30.abstractfactory.element.linux.LinuxCheckBox;
import by.teachmeskills.lesson30.abstractfactory.element.linux.LinuxLabel;

public class LinuxElementFactory implements ElementFactory {

    @Override
    public Button createButton() {
        return new LinuxButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new LinuxCheckBox();
    }

    @Override
    public Label createLabel() {
        return new LinuxLabel();
    }
}
