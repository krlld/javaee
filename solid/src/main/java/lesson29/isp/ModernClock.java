package lesson29.isp;

import java.time.LocalTime;

public class ModernClock implements  Clock, Thermometer {

    @Override
    public LocalTime showTime() {
        return LocalTime.now();
    }

    @Override
    public float readThermometer() {
        return 0;
    }
}
