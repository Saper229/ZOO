package exceptions;

public class AnimalNotFoundException extends ZooException {
    public AnimalNotFoundException(String message) {
        super(message);
    }
}