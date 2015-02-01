/*
 * Pocetak programa kojim se korisniku omogucava da bira fajl
 * za citanje (i snimanje)
 * NAPOMENA: U ovom obliku ne obavlja do kraja navedene funkcije
 */
import java.io.*;
import javax.swing.JFileChooser;

public class StreamWithChooser {
	
	private static void cleanBuffer(byte[] buffer, int numRead)
	{
		for (int i=0; i < numRead; i++)
		{
			buffer[i] = 0;
		}
	}
	
	public static void main(String[] args) {
		
		JFileChooser filePicker = new JFileChooser();
		File f = new File("");
		filePicker.setCurrentDirectory(new File(System.getProperty("user.home")+"/Documents/workspace"));
		int open = filePicker.showOpenDialog(filePicker);
		while (open != filePicker.APPROVE_OPTION) {
			filePicker.showOpenDialog(filePicker);
		}
		filePicker.showSaveDialog(filePicker);

		String pickerFile = filePicker.getSelectedFile().getAbsolutePath();
		
		Reader is;
		FileInputStream fs = null;
		
		byte[] inputBuffer = new byte[10];
		
		FileOutputStream ofs;
	}
}