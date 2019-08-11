package shuun.chapte8;

public class ThreadSample {

	public static void main(String[] args) {
		// Threadクラスを継承したサブクラスのオブジェクト作成
		SubThreadA mt1 = new SubThreadA();
		SubThreadB mt2 = new SubThreadB();

		// サブクラスの実行
		mt1.start();
		mt2.start();

//		try {
//			mt1.start();
//			mt1.join(); // SubThreadAが終了するまで待機
//			mt2.start();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}
}