package by.teachmeskills.lesson30.abstractfactory.element.macos;

import by.teachmeskills.lesson30.abstractfactory.element.Button;

public class MacOSButton implements Button {

    @Override
    public void click() {
        System.out.println("MacOS button click");
    }
}
