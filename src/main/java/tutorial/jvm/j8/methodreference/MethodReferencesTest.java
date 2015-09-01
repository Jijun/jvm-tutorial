package tutorial.jvm.j8.methodreference;

import java.util.ArrayList;
import java.util.List;

public class MethodReferencesTest {
	public static void main(String[] args) {

		List<String> all = new ArrayList<String>();

		all.add("List");
		all.add("Array");
		

		all.forEach(System.out::println);
	}
}
