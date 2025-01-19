package aston.intensive.myLittleSpring;

import aston.intensive.myLittleSpring.interfaces.ISeedCollector;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Collect seed to Collection
 */
public class SeedCollector implements ISeedCollector {

    /**
     * Collect seeds
     *
     * @param classes type List of Class</?>
     * @return Map where key is Class type and value is Seed type
     */
    public Map<Class<?>, Seed> collectSeeds(List<? extends Class<?>> classes) {
        return classes.stream()
                .collect(Collectors.toMap(Function.identity(), SeedFactory::create));
    }


}
