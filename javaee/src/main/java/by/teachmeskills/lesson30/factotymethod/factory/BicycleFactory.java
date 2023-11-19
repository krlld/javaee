package by.teachmeskills.lesson30.factotymethod.factory;

import by.teachmeskills.lesson30.factotymethod.wheel.Bicycle;
import by.teachmeskills.lesson30.factotymethod.wheel.Wheel;

public class BicycleFactory implements WheelFactory {

    @Override
    public Wheel createWheel() {
        return new Bicycle();
    }
}
