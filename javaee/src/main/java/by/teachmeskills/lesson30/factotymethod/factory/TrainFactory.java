package by.teachmeskills.lesson30.factotymethod.factory;

import by.teachmeskills.lesson30.factotymethod.wheel.Train;
import by.teachmeskills.lesson30.factotymethod.wheel.Wheel;

public class TrainFactory implements WheelFactory {

    @Override
    public Wheel createWheel() {
        return new Train();
    }
}
