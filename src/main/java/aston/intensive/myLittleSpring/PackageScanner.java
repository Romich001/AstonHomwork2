package aston.intensive.myLittleSpring;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Stream;

public class PackageScanner implements IPackageScanner {

    public List<? extends Class<?>> scan(String packageName) {

        List<? extends Class<?>> names;
        Path path = Paths.get("target", "classes", "aston", "intensive", packageName);



        try (Stream<Path> pathStream = Files.walk(path)) {
            names = pathStream
                    .filter(Files::isRegularFile)
                    .map(this::getName)
                    .map((String className) -> {
                        try {
                            return Class.forName(className);
                        } catch (ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .filter(clazz -> clazz.isAnnotationPresent(IntensiveComponent.class))
                    .toList();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return names;
    }

    private String getName(Path path) {
        StringJoiner sj = new StringJoiner(".");
        for (int i = 2; i < path.getNameCount(); i++) {
            sj.add(path.getName(i).toString());
        }
        return sj.toString().substring(0, sj.toString().lastIndexOf(".")).trim();
    }


}
