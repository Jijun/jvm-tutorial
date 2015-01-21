package tutorial.jvm.chap01;

import java.util.ArrayList;
import java.util.List;

/**
 * 运行时常量池溢出
 * VM args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * 
 * @author ranger
 * 
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();

        int i = 0;
        while (true) {
            list.add(String.valueOf("sssssssssssssssssssssssssssssssss" + i++).intern());
        }

    }

}
