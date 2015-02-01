/*
 * Program koji cita sadrzaj jednog fajla i upisuje ga u drugi fajl
 * (kao StreamReadFromFileWriteToFile), ali cita liniju po liniju
 */
import java.io.*;

public class StreamReadFromFileWriteToFile1 {
//	private static void cleanBuff(byte[] inputBuffer, int numRead) {	
//		for (int i = 0; i < numRead; i++) {
//			inputBuffer[i] = 0;			
//		}		
//	}
	public static void main(String[] args) {
		FileInputStream fs = null;
		Reader is;
		
		byte[] inputBuffer = new byte[10];
		
		FileOutputStream ofs;
		OutputStream os;
		StringBuilder outputBuilder = new StringBuilder();
		
		try {
			fs = new FileInputStream("./Files/input1.txt");
			is = new InputStreamReader(fs);
			BufferedReader bs = new BufferedReader(is);
			ofs = new FileOutputStream("./Files/output1.txt");
			os = new DataOutputStream(ofs);
			
			int numRead = 0;
//			while (( numRead = is.read(inputBuffer)) >= 0) {
//				outputBuilder.append(new String(inputBuffer));
//				cleanBuff(inputBuffer, numRead);	}
			String lineString = "";
			while ((lineString = bs.readLine()) != null) {
				os.write(lineString.getBytes());
				os.write("\n".getBytes());
			}
			
			System.out.println("Citanje zavrseno");
			String outputString = outputBuilder.toString();
			os.write(outputString.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}