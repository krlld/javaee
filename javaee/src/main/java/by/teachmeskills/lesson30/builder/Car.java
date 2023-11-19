package by.teachmeskills.lesson30.builder;

public class Car {

    private int wheelsCount;

    private String Engine;

    public static CarBuilder builder() {
        return new CarBuilderImpl();
    }

    public int getWheelsCount() {
        return wheelsCount;
    }

    public void setWheelsCount(int wheelsCount) {
        this.wheelsCount = wheelsCount;
    }

    public String getEngine() {
        return Engine;
    }

    public void setEngine(String engine) {
        Engine = engine;
    }
}
