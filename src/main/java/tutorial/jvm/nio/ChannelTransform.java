package tutorial.jvm.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class ChannelTransform {
	public static void main(String[] args) {

		String fromFile = "/tmp/from.txt";
		String toFile = "/tmp/to.txt";

		try (RandomAccessFile fromFiler = new RandomAccessFile(fromFile, "r");RandomAccessFile toFiler = new RandomAccessFile(toFile, "rw")) {

			FileChannel fromChannel = fromFiler.getChannel();

			FileChannel toChannel = toFiler.getChannel();

			long position = 0;
			
			long count = fromChannel.size();

			toChannel.transferFrom(fromChannel, position, count);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
