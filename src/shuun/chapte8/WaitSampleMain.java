package shuun.chapte8;

public class WaitSampleMain {

	public static void main(String[] args) {

		// スレッド処理の対象となるオブジェクトを生成
		WaitTarget wt = new WaitTarget();

		try {
			// A〜Dのスレッドを開始
			WaitThread ws1 = new WaitThread("スレッドA", wt);
			WaitThread ws2 = new WaitThread("スレッドB", wt);
			WaitThread ws3 = new WaitThread("スレッドC", wt);
			WaitThread ws4 = new WaitThread("スレッドD", wt);
			Thread t1 = new Thread(ws1);
			Thread t2 = new Thread(ws2);
			Thread t3 = new Thread(ws3);
			Thread t4 = new Thread(ws4);
			t1.start();
			t2.start();
			t3.start();
			t4.start();

			Thread.sleep(8000);// 8秒待つ

			NotifyThread ns = new NotifyThread(wt);
			ns.start();

		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}