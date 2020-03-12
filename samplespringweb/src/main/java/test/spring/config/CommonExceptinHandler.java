package test.spring.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import test.spring.SpringProCoreException;
import test.spring.SpringProErrorResponse;
import test.spring.SpringProException;
import test.spring.SpringProPersistenceException;

@RestControllerAdvice
public class CommonExceptinHandler {

    @ExceptionHandler(SpringProCoreException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public SpringProErrorResponse springProCoreException(SpringProCoreException ex) {

        return buildErrorResponse("KO", ex.getMessage());
    }

    @ExceptionHandler(SpringProPersistenceException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public SpringProErrorResponse springProPersistenceException(SpringProPersistenceException ex) {

        return buildErrorResponse("KO", ex.getMessage());
    }

    @ExceptionHandler(SpringProException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public SpringProErrorResponse springProException(SpringProException ex) {

        return buildErrorResponse("KO", ex.getMessage());
    }

    private SpringProErrorResponse buildErrorResponse(String status, String errMessage) {
        SpringProErrorResponse response = new SpringProErrorResponse();
        response.setDescription(errMessage);
        response.setStatus(status);
        return response;
    }
}
