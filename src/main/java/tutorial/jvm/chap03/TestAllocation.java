package tutorial.jvm.chap03;

public class TestAllocation {
    private static final int _1MB = 1024 * 1024;

    /**
     * -XX:+PrintGCDetails -verbose:gc -Xms20M -Xmn10M -XX:SurvivorRatio=8
     * 
     * @param args
     */
    public static void main(String[] args) {

        byte[] allocations1, allocations2, allocations3, allocations4;

        allocations1 = new byte[2 * _1MB];
        allocations2 = new byte[2 * _1MB];
        allocations3 = new byte[2 * _1MB];
        allocations4 = new byte[4 * _1MB];

    }
}
