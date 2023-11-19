package by.teachmeskills.lesson30.prototype;

public class Pilot implements Cloneable {

    private String name;
    public int age;

    @Override
    public Pilot clone() throws CloneNotSupportedException {
        Pilot clone = (Pilot) super.clone();
        clone.age = age;
        clone.name = name;
        return clone;
    }
}
