package tutorial.jvm.chap01;

/**
 * VM Args: -Xss2M
 * 
 * @author ranger Exception in thread "main" java.lang.StackOverflowError at
 *         tutorial.jvm.chap01.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:14)
 */
public class JavaVMStackOOM {
    private void dontStop() {
        while (true) {

        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread t = new Thread(new Runnable() {
                public void run() {
                    dontStop();
                }

            });

        }

    }

    public static void main(String[] args) {

        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }

}
