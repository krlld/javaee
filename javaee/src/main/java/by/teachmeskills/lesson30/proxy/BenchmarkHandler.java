package by.teachmeskills.lesson30.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class BenchmarkHandler implements InvocationHandler {

    private final Computer original;

    public BenchmarkHandler(Computer original) {
        this.original = original;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long begin = System.nanoTime();
        method.invoke(original, args);
        long end = System.nanoTime();
        System.out.println(end - begin);
        return null;
    }
}
