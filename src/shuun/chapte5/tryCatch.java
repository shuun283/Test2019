package shuun.chapte5;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class tryCatch {

	public static void main(String[] args) {
		// 1.ファイルのパスを指定する
		File file = new File("C:\\Users\\シンク\\Desktop\\Test.txt");

		// 2.ファイルが存在しない場合に例外が発生するので確認する
		if (!file.exists()) {
			System.out.print("ファイルが存在しません");
			return;
		}

		// 3.FileReaderクラスとreadメソッドを使って1文字ずつ読み込み表示する
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(file);

			int data;
			while ((data = fileReader.read()) != -1) {
				System.out.print((char) data);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4.最後にファイルを閉じてリソースを開放する
			try {
				if (fileReader != null) {
					fileReader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}