package lesson29.isp;

import java.time.LocalTime;

public class DigitalClock implements Clock, Thermometer, RadioPlayer {

    @Override
    public LocalTime showTime() {
        return LocalTime.now();
    }

    @Override
    public void tuneInToRandomRadio() {
    }

    @Override
    public float readThermometer() {
        return 0;
    }
}
