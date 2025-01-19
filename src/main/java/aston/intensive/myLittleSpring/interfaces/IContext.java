package aston.intensive.myLittleSpring.interfaces;

import java.lang.reflect.InvocationTargetException;

public interface IContext {

    <T> T getObject(Class<T> clazz);
}
