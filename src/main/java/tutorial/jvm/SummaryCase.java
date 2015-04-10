package tutorial.jvm;

import java.util.ArrayList;
import java.util.List;

public class SummaryCase {
    /**
     * -Xms30m -Xmx30m -Xmn10m -XX:+UseParallelGC
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        List<Object> caches = new ArrayList<Object>();
        for (int i = 0; i < 7; i++) {
            caches.add(new byte[1024 * 1024 * 3]);
        }
        caches.clear();
        for (int i = 0; i < 2; i++) {
            caches.add(new byte[1024 * 1024 * 3]);
        }
        Thread.sleep(10000);
    }
}