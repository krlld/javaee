package by.teachmeskills.lesson30.singleton;

public class Singleton {

    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {
    }

    public Singleton getInstance() {
        return INSTANCE;
    }

}
