package by.teachmeskills.lesson31.decorator;

public class LoggingDataSourceDecorator extends BaseDataSourceDecorator {

    public LoggingDataSourceDecorator(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void operation() {
        logging();
        getDataSource().operation();
    }

    private void logging() {
        System.out.println("Logging ....");
    }
}
