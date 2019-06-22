package shuun.chapte5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class tryWithResources {

	public static void main(String[] args) {
		String dir = "C:\\tryWithResources";
		String filename1 = "\\test1.png";
		String filename2 = "\\test2.png";

//		try-with-resources文
//		tryの後ろのかっこにresource (リソース)を記述します。
//		リソースとは、AutoCloseableインターフェースまたはCloseableインタフェースを実装したクラスをインスタンス化した変数の宣言です。
//		tryのブロックを抜けるときにリソースがcloseされます。
//		※「{」(波括弧) から「}」までをブロックといいます。
//		→finally句でのリソースをcloseする記述が不要になります。
//		リソースのスコープはtryブロック配下のみです。
//		リソースが複数ある場合はセミコロンで区切ります。
//		リソースのclose処理中に発生した例外は無視されます。
//		リソースのcloseの順番は定義の逆の順番です。
//		Java 7で導入されました。
		try (FileInputStream reader = new FileInputStream(dir + filename1);
				FileOutputStream writer = new FileOutputStream(dir + filename2)) {

			int data;
			while ((data = reader.read()) != -1) {
				writer.write(data);
			}
		} catch (IOException e) {
			e.printStackTrace();

//		finally句でのリソースのcloseは不要
		} finally {
//					try{
//						if (reader!=null){
//							reader.close();
//						}
//						if (writer!=null){
//							writer.close();
//						}
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
		}
	}
}
