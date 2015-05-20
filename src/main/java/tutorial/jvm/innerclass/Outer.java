package tutorial.jvm.innerclass;

public class Outer {

	public class Inner  {
		
	}
	public static void main(String[] args) {
		new Outer().new Inner();
		
		Outer o = new Outer();
		o.new Inner();
		
		int []a[] = new int[1][];
	}
	
}
