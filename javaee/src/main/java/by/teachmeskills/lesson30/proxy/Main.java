package by.teachmeskills.lesson30.proxy;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        SuperComputer superComputer = new SuperComputer();
        BenchmarkHandler benchmarkHandler = new BenchmarkHandler(superComputer);
        Computer computer = (Computer) Proxy.newProxyInstance(Computer.class.getClassLoader(),
                new Class[] {Computer.class},
                benchmarkHandler);
        computer.process(100000L);
    }
}
