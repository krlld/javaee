package by.teachmeskills.lesson30.builder;

public class CarBuilderImpl implements CarBuilder {

    private final Car car;

    public CarBuilderImpl() {
        car = new Car();
    }

    @Override
    public CarBuilder wheelsCount(int wheelsCount) {
        car.setWheelsCount(wheelsCount);
        return this;
    }

    @Override
    public CarBuilder engine(String engine) {
        car.setEngine(engine);
        return this;
    }

    @Override
    public Car build() {
        return car;
    }
}
