package test.spring;


import org.apache.log4j.Logger;

public abstract class SpringProException extends RuntimeException {
    private static final Logger LOGGER = Logger.getLogger(SpringProException.class);

    private String message;
    private Throwable cause;


    public SpringProException(String message) {
        this.message = message;
    }

    public SpringProException(String message, Throwable cause) {
        this(message);
        this.cause = cause;
    }

    public SpringProException(Throwable cause) {
        this.cause = cause;
    }


    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Throwable getCause() {
        return cause;
    }

    public void setCause(Throwable cause) {
        this.cause = cause;
    }
}
