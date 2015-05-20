package tutorial.jvm;

public class Test extends Test1 {


    static {
        System.out.println("D");
    }

    public Test(){
        System.out.println("F");
    }

    public static void main(String []args) {
        Test t = null;
        Test t2 = new Test();

    }
    static {
        System.out.println("E");
    }
    {//execute before constructor
        System.out.println("C");
    }

}
