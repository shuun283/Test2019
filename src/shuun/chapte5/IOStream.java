package shuun.chapte5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOStream {

	public static void main(String[] args) {
		File inputFile = null;
		File outputFile = null;
		FileInputStream in = null;
		FileOutputStream out = null;
		
		try {
			inputFile = new File("C:\\Users\\softthink\\Desktop\\input.txt");
			outputFile = new File("C:\\Users\\softthink\\Desktop\\output.txt");
			in = new FileInputStream(inputFile);
			out = new FileOutputStream(outputFile);
			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
			}
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
		} catch (IOException e) {
			System.out.println("IOException");
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					in.close();
				}
			} catch (IOException e) {
				System.out.println("close fail");
				e.printStackTrace();
			}
		}
	}

}