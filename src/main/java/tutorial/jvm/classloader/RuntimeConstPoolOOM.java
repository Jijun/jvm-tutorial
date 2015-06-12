package tutorial.jvm.classloader;

/**
 * 
 * 1.在JDK6运行返回false,false
 * 2.在JDK7运行返回true,false
 * 原因是JDK7常量池，intern不会在常量池中复制，返回的是堆中的引用
 * 
 * 
 * 
 * 
 * 
 * @author ranger
 *
 */
public class RuntimeConstPoolOOM {
	public static void main(String[] args) {
		String str1 = new StringBuilder("计算机").append("liu").toString();
		System.out.println(str1.intern() == str1);

		String str2 = new StringBuilder("ja").append("va").toString();
		System.out.println(str2.intern() == str2);
	}

}
