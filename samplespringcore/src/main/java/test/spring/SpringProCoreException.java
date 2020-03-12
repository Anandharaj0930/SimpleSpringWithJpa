package test.spring;

public class SpringProCoreException extends SpringProException {

    public SpringProCoreException(String message) {
        super(message);
    }

    public SpringProCoreException(String message, Throwable cause) {
        super(message, cause);
    }

    public SpringProCoreException(Throwable cause) {
        super(cause);
    }
}
