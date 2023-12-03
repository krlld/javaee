package by.teachmeskills.lesson31.decorator;

public class Main {

    public static void main(String[] args) {
        DataSource dataSource = new LoggingDataSourceDecorator(new TransactionalDataSourceDecorator(new DataBase()));
        dataSource.operation();
    }
}
