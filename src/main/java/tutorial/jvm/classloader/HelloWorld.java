package tutorial.jvm.classloader;

/**
 * Created by ranger on 5/11/15.
 */
public class HelloWorld {

    public static void main(String[] args) {

        ClassLoader loader = HelloWorld.class.getClassLoader();

        while (loader != null) {
            System.out.println("classloader'name is " + loader);
            loader = loader.getParent();
        }
        //Bootstrap classloader is null
        System.out.println(loader);

    }

}
