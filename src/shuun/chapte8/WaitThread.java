package shuun.chapte8;

public class WaitThread implements Runnable {

	String str;
	WaitTarget wt;

	public WaitThread(String str, WaitTarget wt) {
		this.str = str;
		this.wt = wt;
	}

	@Override
	public void run() {
		try {
			wt.count(str);
			wt.wtWait(str);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(str + "を終了");
	}
}