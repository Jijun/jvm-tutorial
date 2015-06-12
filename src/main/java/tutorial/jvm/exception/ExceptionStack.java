package tutorial.jvm.exception;

import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;

public class ExceptionStack {

	public static void main(String[] args) {

		String pathname = "/tmp/a.txt";
		System.out.println(System.console()==null);
		
		try (FileInputStream fis = new FileInputStream("/tmp/a.txt")) {

//		Externalizable
		} catch (IOException e) {
			StackTraceElement []elments  = e.getStackTrace();
			
			for(int i=0,sum=elments.length;i<sum;i++) {
				System.out.println(elments[i].getFileName() + ":" + elments[i].getLineNumber() + ">>" + elments[i].getMethodName()+"()");
			}
			
		} finally {
		}

	}

}
