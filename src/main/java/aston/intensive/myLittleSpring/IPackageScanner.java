package aston.intensive.myLittleSpring;

import java.util.List;

public interface IPackageScanner {

     List<? extends Class<?>> scan(String packageName);
}
