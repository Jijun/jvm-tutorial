package tutorial.jvm.j8.stream;

import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class StreamTest {
	public static void main(String[] args) {

		List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

		myList.stream().filter(s -> s.startsWith("a")).map(String::toUpperCase)
				.sorted().forEach(System.out::print);

		myList.stream().findFirst().ifPresent(System.out::print);

		FileFilter filter = (f) -> f.isDirectory();

	}
}
