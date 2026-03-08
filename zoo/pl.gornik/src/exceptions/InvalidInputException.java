package exceptions;

// Błąd przy wprowadzaniu danych (np. litera zamiast cyfry)
public class InvalidInputException extends ZooException {
    public InvalidInputException(String message) { super(message); }
}
