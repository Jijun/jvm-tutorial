package tutorial.jvm.chap03;

public class TestAllocation2 {

    /** vm params: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8
     * 
     * -XX:PretenureSizeThreshold=3145728 //超过这个尺寸将直接进入老年代，
     * 
     * 
     * @param args
     */
    public static void main(String[] args) {

        byte[] alloc = new byte[4 * 1024 * 1024];

    }
}
