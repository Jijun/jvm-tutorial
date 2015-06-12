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

        System.out.println(5%3);
        System.out.print(5&(3-1));
        
    }
    static {
        System.out.println("E");
    }
    {//execute before constructor
        System.out.println("C");
    }

}
