package aston.intensive.myLittleSpring;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Comparator;

/**
 * This class encapsulate logic of creating Seeds from objects of type Class</T>
 */
class SeedFactory {

    /**
     * Method create Seed by Class</T>
     *
     * @param clazz type Class</T>
     * @param <T>   generic type of Class
     * @return Seed of this T.class
     */
    public static <T> Seed create(Class<T> clazz) {
        var constructor = constructorCreator(clazz);
        var argsTypes = constructor.getParameterTypes();
        return new Seed(constructor, argsTypes);
    }

    private static Constructor<?> constructorCreator(Class<?> clazz) {
        return Arrays.stream(clazz.getConstructors())
                .max(Comparator.comparingInt(Constructor::getParameterCount))
                .orElseThrow();
    }
}
