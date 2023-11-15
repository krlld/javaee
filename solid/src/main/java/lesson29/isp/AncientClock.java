package lesson29.isp;

import java.time.LocalTime;

public class AncientClock implements Clock {

    @Override
    public LocalTime showTime() {
        return LocalTime.now();
    }
}
