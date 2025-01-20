package aston.intensive.myLittleSpring;

import aston.intensive.myLittleSpring.exceptions.NoSuchSeedException;
import aston.intensive.myLittleSpring.interfaces.IContext;
import aston.intensive.myLittleSpring.interfaces.IFactorySeeds;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Presents context of LittleSpring. Implements IContext interface
 * This class manage objects that marked with @IntensiveComponent
 */
public class LittleSpringContext implements IContext {

    private final Map<Class<?>, Seed> map;

    /**
     * @param targetPackage is String that presents name of package
     *                      where LittleSpring looks for classes that marked with annotation @IntensiveComponent
     */
    public LittleSpringContext(String targetPackage) {
        map = IFactorySeeds.defaultFactorySeeds().createSeedsMap(targetPackage);
    }

    /**
     * @param clazz the instance of Class object that is generic <T>
     * @param <T>   type that will be returned
     * @return instance of clazz that in LittleSpringContext of type T
     * @throws NoSuchSeedException this exception means that LittleSpring don't manage this type of objects
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> T getObject(Class<T> clazz) {
        var classSeed = map.get(clazz);
        if (classSeed == null) throw new NoSuchSeedException(clazz);
        return (T) getInstance(classSeed);
    }

    private Object getInstance(Seed classSeed) {
        try {
            var args = getArgs(classSeed);
            return classSeed.constructor().newInstance(args);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private Object[] getArgs(Seed classSeed) {
        var args = new Object[classSeed.argTypes().length];
        for (int i = 0; i < args.length; i++) {
            var current = classSeed.argTypes()[i];
            args[i] = getObject(current);
        }
        return args;
    }


}
