/* Napomena: U odnosu na StreamReaderWrite.java ovaj program
 * je promijenjen samo na dva mjesta (vidi komentare). Vise ne
 * cita sa "System.in" nego iz fajla (preko FileInputStream)
 */
import java.io.*;

public class StreamReadFromFileWriteToConsole {

	private static void cleanBuffer(byte[] buffer, int numRead) {
		for (int i = 0; i < numRead; i++) {
			buffer[i] = 0;
		}
	}
		
	public static void main(String[] args) {
			
		// ubaceno narednih 6 redova (obrati paznju na e1)
		FileInputStream fs = null;
		try {
			fs = new FileInputStream("./Files/nesto.txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		// ova linija promijenjena (samo fs ubaceno)
		InputStream is = new DataInputStream(fs);
		byte[] inputBuffer = new byte[10];
			
		OutputStream os = new DataOutputStream(System.out);
		StringBuilder outputBuilder = new StringBuilder();
			
		try {
			int numRead = 0;
			while (( numRead = is.read(inputBuffer)) >= 0) {
				outputBuilder.append(new String(inputBuffer));
				cleanBuffer(inputBuffer, numRead);
			}
			System.out.println("Citanje zavrseno");
			String outputString = outputBuilder.toString();
			os.write(outputString.getBytes());
											
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}