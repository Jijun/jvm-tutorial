package tutorial.jvm.j8.lambda;

import java.util.Arrays;

public class ForEachLambdaTest {
	public static void main(String[] args) {

		Arrays.asList("a", "b", "d").forEach(e -> System.out.println(e));

		Arrays.asList("a", "b", "d").forEach((String e) -> System.out.println(e));
		
		ForEachLambdaTest tester = new ForEachLambdaTest();

		MathOperation addition = (int a, int b) -> a + b;
		MathOperation subtraction = (a, b) -> a - b;
		MathOperation multiplication = (a, b) -> a * b;
		MathOperation division = (a, b) -> a / b;

		System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
		System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
		System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
		System.out.println("10 / 5 = " + tester.operate(10, 5, division));

		// with parenthesis
		GreetingService greetService1 = message -> System.out.println("Hello "
				+ message);

		// without parenthesis
		GreetingService greetService2 = (message) -> System.out
				.println("Hello " + message);

		greetService1.sayMessage("Mahesh");
		greetService2.sayMessage("Suresh");
	}

	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}
}

interface MathOperation {
	int operation(int a, int b);
}

interface GreetingService {
	void sayMessage(String message);
}