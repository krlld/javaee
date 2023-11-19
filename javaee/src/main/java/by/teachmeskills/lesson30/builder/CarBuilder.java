package by.teachmeskills.lesson30.builder;

public interface CarBuilder {

    CarBuilder wheelsCount(int wheelsCount);

    CarBuilder engine(String engine);

    Car build();
}
