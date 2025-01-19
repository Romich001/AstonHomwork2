package aston.intensive.model.subpackage;

import aston.intensive.model.SomeClass;
import aston.intensive.myLittleSpring.annotations.IntensiveComponent;

@IntensiveComponent
public class AnotherClass {

    private final SomeClass someClass;

    public AnotherClass(SomeClass someClass) {
        this.someClass = someClass;
    }


    public void go() {
        someClass.run();
        System.out.println("AnotherClass.go() is called");
    }
}
