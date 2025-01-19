package aston.intensive.myLittleSpring;

import aston.intensive.myLittleSpring.exceptions.ComponentScanException;
import aston.intensive.myLittleSpring.interfaces.IPackageScanner;
import aston.intensive.myLittleSpring.annotations.IntensiveComponent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Stream;

/**
 * Class implements IPackageScanner interface.
 * It is scanning files in package and collect that contains annotation IntensiveComponent
 */

public class PackageScanner implements IPackageScanner {

    /**
     * Method checks classes in the package if it has annotation IntensiveComponent then put it in a list
     *
     * @param packageName String name of target package
     * @return list of classes that has IntensiveComponent
     * @throws ComponentScanException when exception in scanning is occur
     */
    public List<? extends Class<?>> scan(String packageName) {
        List<? extends Class<?>> names;
        Path path = Paths.get("target", "classes", "aston", "intensive", packageName);

        try (Stream<Path> pathStream = Files.walk(path)) {
            names = pathStream
                    .filter(Files::isRegularFile)
                    .map(this::getName)
                    .map(this::getClass)
                    .filter(clazz -> clazz.isAnnotationPresent(IntensiveComponent.class))
                    .toList();

        } catch (IOException e) {
            throw new ComponentScanException(packageName);
        }
        return names;
    }

    private Class<?> getClass(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private String getName(Path path) {
        StringJoiner sj = new StringJoiner(".");
        for (int i = 2; i < path.getNameCount(); i++) {
            sj.add(path.getName(i).toString());
        }
        return sj.toString().substring(0, sj.toString().lastIndexOf(".")).trim();
    }


}
