package shuun.chapte8;

public class WaitTarget {
	public synchronized void count(String str) throws InterruptedException {
		System.out.print(str + "の処理を開始：");
		for (int i = 3; i > 0; i--) {
			System.out.print(i + "→");
			Thread.sleep(500);// 0.5秒待つ
		}
		System.out.println("0");
	}

	public synchronized void wtWait(String str) throws InterruptedException {
		System.out.println(str + "の処理を停止");

		// 他のスレッドがこのオブジェクトのnotify() メソッドまたは、notifyAll()メソッドを呼び出すまで、現在のスレッドを待機させます。
		wait(10000);// 最大で10秒間停止する
	}

	public synchronized void wtNotify() {
		System.out.println("停止中の処理を再開する");

		// wait()メソッドによって待機中であるスレッドの1つを再開します。
		// 再開するスレッドは、Java仮想マシンによって任意に選ばれ、プログラム側から指定することはできません。
		notify();// 停止中のスレッドを再開
	}
}