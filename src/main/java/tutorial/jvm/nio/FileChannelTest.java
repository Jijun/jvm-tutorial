package tutorial.jvm.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.RandomAccess;

public class FileChannelTest {
	public static void main(String[] args) throws IOException {

		try {
			RandomAccessFile raf = new RandomAccessFile("/tmp/a.txt", "r");

			FileChannel fchannel = raf.getChannel();

			ByteBuffer byteBuf = ByteBuffer.allocate(48);

			int byteRead = fchannel.read(byteBuf);

			while (byteRead != -1) {

				System.out.println("Read " + byteRead);

				byteBuf.flip();
//				byteBuf.rewind();
				while (byteBuf.hasRemaining()) {
					System.out.print((char) byteBuf.get());
				}

				byteBuf.clear();
				byteRead = fchannel.read(byteBuf);
			}

			fchannel.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	} 
}
