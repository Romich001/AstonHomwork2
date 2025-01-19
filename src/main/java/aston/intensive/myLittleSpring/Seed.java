package aston.intensive.myLittleSpring;

import java.lang.reflect.Constructor;

/**
 * This class represents object that MyLittleSpring manage. Contains fields to create an instance of specific class.
 *
 * @param constructor field of type Constructor
 * @param argTypes    field of type Class</?>[]
 */
public record Seed(
        Constructor<?> constructor,
        Class<?>[] argTypes
) {
}
