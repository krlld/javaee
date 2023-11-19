package by.teachmeskills.lesson30.prototype;

public class Plane implements Cloneable {

    private String name;

    private Pilot pilot;

    @Override
    public Plane clone() throws CloneNotSupportedException {
        Plane clone = (Plane) super.clone();
        clone.name = name;
        clone.pilot = pilot.clone();
        return clone;
    }
}
