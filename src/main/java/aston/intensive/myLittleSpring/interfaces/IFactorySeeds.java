package aston.intensive.myLittleSpring.interfaces;

import aston.intensive.myLittleSpring.FactorySeeds;
import aston.intensive.myLittleSpring.Seed;

import java.util.Map;

public interface IFactorySeeds {

    Map<Class<?>, Seed> createSeedsMap(String packageName);

    static IFactorySeeds defaultFactorySeeds() {
        return new FactorySeeds();
    }
}
