package aston.intensive;

import aston.intensive.model.subpackage.AnotherClass;
import aston.intensive.myLittleSpring.LittleSpringContext;

public class Main {

    public static void main(String[] args) {

        var context = new LittleSpringContext("model");
        var anotherClass = context.getObject(AnotherClass.class);
        anotherClass.go();

    }
}