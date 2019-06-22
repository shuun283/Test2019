package shuun.chapte5;

import java.io.File;

public class NaviGate {

	public static void main(String[] args) {
		String treeRoot = ".";
		if (args.length >= 1) {
			treeRoot = args[0];
		}
		
		File rootDir = new File(treeRoot);
		System.out.println(rootDir.getAbsolutePath());
		
		if (rootDir.isDirectory()) {
			System.out.println("Exisit as a directory");
			System.exit(0);
		}
		
		NaviGate obj = new NaviGate();
		obj.navigete(rootDir);
	}

	public void navigete(File dir) {
		System.out.println(" ");
		System.out.println("Directory " + dir + ":");

		String[] dirContent = dir.list();
		for (int i = 0; i < dirContent.length; i++) {
			System.out.println(dirContent[i]);
			File child = new File(dir, dirContent[i]);
			if (child.isDirectory()) {
				navigete(child);
			}
		}
	}
}
