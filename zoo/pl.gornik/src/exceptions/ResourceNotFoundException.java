package exceptions;

// Błąd braku zasobu (np. brak zwierzęcia na liście)
public class ResourceNotFoundException extends ZooException {
    public ResourceNotFoundException(String message) { super(message); }
}
