package tutorial.jvm;

/**
 * Created by ranger on 5/11/15.
 */
public class Test1 {

    static {
        System.out.println("A");
    }

    public Test1 () {
        System.out.println("B");
    }


    {//execute before constructor
        System.out.println("G");
    }

public static void main(String[] args) {
	System.out.println("\u9a8c\u8bc1\u7801\u9519\u8bef");
}
}
