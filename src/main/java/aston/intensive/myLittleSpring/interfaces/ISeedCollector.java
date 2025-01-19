package aston.intensive.myLittleSpring.interfaces;

import aston.intensive.myLittleSpring.Seed;
import aston.intensive.myLittleSpring.SeedCollector;

import java.util.List;
import java.util.Map;

public interface ISeedCollector {
    Map<Class<?>, Seed> collectSeeds(List<? extends Class<?>> classes);

    static ISeedCollector defaultCollector() {
        return new SeedCollector();
    }
}
