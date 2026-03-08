package exceptions;

public class InsufficientFundsException extends ZooException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}