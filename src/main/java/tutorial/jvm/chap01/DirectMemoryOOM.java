package tutorial.jvm.chap01;

import java.lang.reflect.Field;

public class DirectMemoryOOM {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
    }

}
