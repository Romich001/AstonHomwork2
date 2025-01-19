package aston.intensive;

import aston.intensive.model.subpackage.AnotherClass;
import aston.intensive.myLittleSpring.LittleSpringContext;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {

        var context = new LittleSpringContext("model");
        var anotherClassClass = context.getObject(AnotherClass.class);
        anotherClassClass.go();

    }
}