package aston.intensive.myLittleSpring;

import aston.intensive.myLittleSpring.interfaces.IFactorySeeds;
import aston.intensive.myLittleSpring.interfaces.IPackageScanner;
import aston.intensive.myLittleSpring.interfaces.ISeedCollector;

import java.util.List;
import java.util.Map;

/**
 * This class creates a map of seeds.
 */
public class FactorySeeds implements IFactorySeeds {

    /**
     * @param packageName String that present name of package that should be scanning for looking up classes whith
     *                    IntensiveComponent annotation
     * @return map where key is Class</?> and value is Seed
     */
    public Map<Class<?>, Seed> createSeedsMap(String packageName) {
        return ISeedCollector.defaultCollector().collectSeeds(scan(packageName));
    }

    private List<? extends Class<?>> scan(String packageName) {
        return IPackageScanner.defaultScanner().scan(packageName);
    }
}
