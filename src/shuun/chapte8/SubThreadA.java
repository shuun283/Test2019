package shuun.chapte8;

public class SubThreadA extends Thread {
	public void run() {
//		try {
//			// 3秒スリープ
//			Thread.sleep(3000);
//			System.out.println("スレッドAを開始しました。");
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

		System.out.println("スレッドAを開始しました。");
	}
}