package shuun.chapte8;

public class YieldThread implements Runnable {

	public static void main(String[] args) {
		Thread t = new Thread(new YieldThread());
		t.start();

		for (int i = 0; i < 5; i++) {
			System.out.println("Inside main");
			// System.out.println("Inside main" + i);
		}
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Inside run");
			Thread.yield();
		}
	}
}