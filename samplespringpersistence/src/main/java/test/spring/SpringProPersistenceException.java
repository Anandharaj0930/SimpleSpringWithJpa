package test.spring;

import test.spring.SpringProException;

public class SpringProPersistenceException extends SpringProException {

    public SpringProPersistenceException(String message) {
        super(message);
    }

    public SpringProPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

    public SpringProPersistenceException(Throwable cause) {
        super(cause);
    }
}
