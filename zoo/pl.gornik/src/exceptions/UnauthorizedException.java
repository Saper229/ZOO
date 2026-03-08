package exceptions;

public class UnauthorizedException extends ZooException {
    public UnauthorizedException(String message) {
        super(message);
    }
}