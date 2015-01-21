package tutorial.jvm.chap01;

/**
 * VM Args:-Xss128k
 * 
 * @author ranger
 * 
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF com = new JavaVMStackSOF();
        try {
            com.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + com.stackLength);
            throw e;
        }
    }

}
