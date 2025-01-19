package aston.intensive.myLittleSpring.exceptions;

/**
 * Exception throws while errors happen while scanning package
 */
public class ComponentScanException extends RuntimeException {
    public ComponentScanException(String message) {
        super("Exception while scanning: " + message);
    }
}
