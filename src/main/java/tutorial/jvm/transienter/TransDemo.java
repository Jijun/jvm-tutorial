package tutorial.jvm.transienter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TransDemo {
	public static void main(String[] args) throws IOException {
		if (args.length != 1) {
			System.err.println("usage: java TransDemo classfile");
			return;
		}
		
		ClassLib cl = new ClassLib(new FileInputStream(args[0]));
		System.out.printf("Minor version number: %d%n", cl.getMinorVer());
		System.out.printf("Major version number: %d%n", cl.getMajorVer());
		cl.showIS();

		try (FileOutputStream fos = new FileOutputStream("x.ser");	ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(cl);
		}

		cl = null;

		try (FileInputStream fis = new FileInputStream("x.ser");
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			System.out.println();
			cl = (ClassLib) ois.readObject();
			System.out.printf("Minor version number: %d%n", cl.getMinorVer());
			System.out.printf("Major version number: %d%n", cl.getMajorVer());
			cl.showIS();
		} catch (ClassNotFoundException cnfe) {
			System.err.println(cnfe.getMessage());
		}
	}

}
