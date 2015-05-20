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


}
