package gettoworktogether.nl.library.exception;

public class NotAuthorizedException extends RuntimeException {
    public NotAuthorizedException() {
        super();
    }
    public NotAuthorizedException(String message) {
        super(message);
    }
}
