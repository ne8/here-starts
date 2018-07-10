package ro.ne8.authorizationserver.exceptions;

public class DuplicateEntityException extends RuntimeException {
    
    public DuplicateEntityException(final String message) {
        super(message);
    }

    public DuplicateEntityException(final String message, final Throwable throwable) {
        super(message, throwable);
    }
}
