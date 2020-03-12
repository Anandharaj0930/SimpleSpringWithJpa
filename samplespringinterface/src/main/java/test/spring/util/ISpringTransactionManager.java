package test.spring.util;

public interface ISpringTransactionManager {

    public <Output> Output executeWithRequiredNew(TransactionOperation<Output> transactionOperation);

    public <Output> Output executeWithNotSupported(TransactionOperation<Output> transaction);

    public <Output> Output executeWithRequired(TransactionOperation<Output> transaction);
}
