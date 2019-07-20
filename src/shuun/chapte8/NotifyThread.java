package shuun.chapte8;

public class NotifyThread extends Thread {

	WaitTarget wt;

	public NotifyThread(WaitTarget wt) {
		this.wt = wt;
	}

	@Override
	public void run() {
		wt.wtNotify();
	}
}