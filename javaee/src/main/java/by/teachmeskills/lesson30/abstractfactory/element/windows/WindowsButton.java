package by.teachmeskills.lesson30.abstractfactory.element.windows;

import by.teachmeskills.lesson30.abstractfactory.element.Button;

public class WindowsButton implements Button {

    @Override
    public void click() {
        System.out.println("Windows button click");
    }
}
