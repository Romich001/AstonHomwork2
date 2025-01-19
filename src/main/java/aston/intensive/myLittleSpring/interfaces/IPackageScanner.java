package aston.intensive.myLittleSpring.interfaces;

import aston.intensive.myLittleSpring.PackageScanner;

import java.util.List;

public interface IPackageScanner {

    List<? extends Class<?>> scan(String packageName);

    static IPackageScanner defaultScanner() {
        return new PackageScanner();
    }
}
