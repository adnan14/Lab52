/*
 * Program koji cita iz jednog fajla i pise u taj isti fajl
 */
import java.io.*;

public class StreamFileToReadToWrite {

	public static void main(String[] args) {
		FileInputStream fs = null;
		Reader is;
				
		FileOutputStream ofs;
		OutputStream os;
		StringBuilder outputBuilder = new StringBuilder();
		
		try {
			fs = new FileInputStream("./Files/input1.txt");
			is = new InputStreamReader(fs);
			BufferedReader bs = new BufferedReader(is);
			ofs = new FileOutputStream("./Files/input1.txt", true);
			os = new DataOutputStream(ofs);
			
			String lineString = "";
			while ((lineString = bs.readLine()) != null) {
				outputBuilder.append(lineString).append("\n");
			}

			// valjda moze i ovako
			//os.write(outputBuilder.toString().getBytes());
			
			System.out.println("Citanje zavrseno");
			String outputString = outputBuilder.toString();
			os.write(outputString.getBytes());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}