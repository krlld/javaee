package by.teachmeskills.lesson30.abstractfactory.element.linux;

import by.teachmeskills.lesson30.abstractfactory.element.Button;

public class LinuxButton implements Button {

    @Override
    public void click() {
        System.out.println("Linux button click");
    }
}
