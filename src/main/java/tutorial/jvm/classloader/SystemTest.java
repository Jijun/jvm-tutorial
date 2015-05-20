package tutorial.jvm.classloader;

import java.net.URL;
import java.util.Map;

/**
 * Created by ranger on 5/11/15.
 */
public class SystemTest {
static {

    for (Map.Entry<Object, Object> entry : System.getProperties().entrySet()) {
        System.out.println(entry.getKey()+"\t"+entry.getValue());
    }
    URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
    for (int i = 0; i < urls.length; i++) {
        System.out.println(urls[i].toExternalForm());
    }
}
    public static void main(String[] args) {
        System.out.println("testtt");
    }

}
