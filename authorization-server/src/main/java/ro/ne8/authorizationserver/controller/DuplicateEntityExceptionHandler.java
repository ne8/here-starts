package ro.ne8.authorizationserver.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ro.ne8.authorizationserver.exceptions.DuplicateEntityException;

@ControllerAdvice
public class DuplicateEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String USER_ALREADY_EXISTS_ERROR_MESSAGE = "User already exists";

    @ExceptionHandler(value = {DuplicateEntityException.class})
    ResponseEntity<Object> handlerDuplicateEntityException(final RuntimeException e, final WebRequest webRequest) {
        return this.handleExceptionInternal(e, USER_ALREADY_EXISTS_ERROR_MESSAGE, new HttpHeaders(), HttpStatus.CONFLICT, webRequest);
    }
}
