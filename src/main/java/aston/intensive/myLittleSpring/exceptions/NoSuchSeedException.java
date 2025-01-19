package aston.intensive.myLittleSpring.exceptions;

/**
 * Exception happens when MyLittleSpring do not manage objects of specified type
 */
public class NoSuchSeedException extends RuntimeException {

    public <T> NoSuchSeedException(Class<T> clazz) {
        super("No such seed: " + clazz);
    }
}
