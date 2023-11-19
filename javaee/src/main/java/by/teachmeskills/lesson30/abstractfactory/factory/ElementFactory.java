package by.teachmeskills.lesson30.abstractfactory.factory;

import by.teachmeskills.lesson30.abstractfactory.element.Button;
import by.teachmeskills.lesson30.abstractfactory.element.CheckBox;
import by.teachmeskills.lesson30.abstractfactory.element.Label;

public interface ElementFactory {

    Button createButton();

    CheckBox createCheckBox();

    Label createLabel();
}
