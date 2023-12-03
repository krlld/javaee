package by.teachmeskills.lesson31.decorator;

public class TransactionalDataSourceDecorator extends BaseDataSourceDecorator {

    public TransactionalDataSourceDecorator(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void operation() {
        beginTransaction();
        getDataSource().operation();
        closeTransaction();
    }

    private void beginTransaction() {
        System.out.println("Begin transaction");
    }

    private void closeTransaction() {
        System.out.println("Close transaction");
    }
}
