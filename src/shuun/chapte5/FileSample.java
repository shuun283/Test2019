package shuun.chapte5;

import java.io.File;

public class FileSample {

	public static void main(String[] args) {
		try {
			File f1 = new File("java\\chapte5");
			File f2 = new File("java\\chapte5","\\chapte5\\FileSample.java");
            File f22 = new File("java\\chapte5","chapte5\\FileSample.java");
			File f3 = new File(f1,"chapte5\\FileSample.java");

			System.out.println("parh for f1: " + f1);
			System.out.println("parh for f2: " + f2);
            System.out.println("parh for f22: " + f22);
			System.out.println("parh for f3: " + f3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
