/* Napomena: Ovo je modifikacija programa
 * 			 StreamReadFromFileWriteToConsole.java
 */
import java.io.*;

public class StreamReadFromFileWriteToConsole1 {

	private static void cleanBuffer(byte[] buffer, int numRead) {
		for (int i = 0; i < numRead; i++) {
			buffer[i] = 0;
		}
	}
		
	public static void main(String[] args) {
			
		FileInputStream fs = null;
		
		byte[] inputBuffer = new byte[10];
			
		OutputStream os = new DataOutputStream(System.out);
		StringBuilder outputBuilder = new StringBuilder();
			
		try {
			fs = new FileInputStream("./Files/nesto.txt");
			InputStream is = new DataInputStream(fs);
			
			int numRead = 0;
			while (( numRead = is.read(inputBuffer)) >= 0) {
				outputBuilder.append(new String(inputBuffer));
				cleanBuffer(inputBuffer, numRead);
			}
			System.out.println("Citanje zavrseno");
			String outputString = outputBuilder.toString();
			os.write(outputString.getBytes());

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		System.out.println("\nGotovo!");
		}
	}
}