/*		
 * Program koji cita sadrzaj jednog fajla i upisuje ga u drugi fajl
 */
import java.io.*;

public class StreamReadFromFileWriteToFile {

	private static void cleanBuffer(byte[] buffer, int numRead) {
		for (int i = 0; i < numRead; i++) {
			buffer[i] = 0;
		}
	}

	public static void main(String[] args) {
		
		// ovo su deklaracije
		FileInputStream fs = null;
		InputStream is;
		
		byte[] inputBuffer = new byte[10];
		
		// deklaracija je ovdje, a inicijalizacija unutar
		// try-catcha (razdvojeno, da se lakse razumije!)
		FileOutputStream ofs;
		OutputStream os;
		StringBuilder outputBuilder = new StringBuilder();
		
		try {
			fs = new FileInputStream("./Files/input.txt");
			is = new DataInputStream(fs);
			ofs = new FileOutputStream("./Files/output.txt");
			os = new DataOutputStream(ofs);
			
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