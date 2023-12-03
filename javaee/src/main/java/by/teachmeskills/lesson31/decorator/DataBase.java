package by.teachmeskills.lesson31.decorator;

public class DataBase implements DataSource {

    @Override
    public void operation() {
        System.out.println("Do some operation with data");
    }
}
