package tutorial.jvm.classloader;

/**
 * Created by ranger on 5/11/15.
 */
public class ClassLoad {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = HelloWorld.class.getClassLoader();
        System.out.println(loader);
        //使用ClassLoader.loadClass()来加载类，不会执行初始化块
       // loader.loadClass("tutorial.jvm.Test");
        //使用Class.forName()来加载类，默认会执行初始化块
               Class.forName("tutorial.jvm.Test");
        //使用Class.forName()来加载类，并指定ClassLoader，初始化时不执行静态块
                Class.forName("tutorial.jvm.Test", false, loader);
                
                
                
                
    }
}
