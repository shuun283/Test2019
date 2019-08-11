package shuun.chapte8;

public class UncaughtExceptionHandlerSample {
	// UncaughtExceptionHandler の実装
	private static class MyExceptionHandler implements Thread.UncaughtExceptionHandler {
		@Override
		public void uncaughtException(Thread t, Throwable e) {
			System.err.println("Uncaught Exception:");
			System.err.println(t.getName()); // Thread ID 1
			System.err.println(e.toString()); // java.lang.IllegalArgumentException
			System.err.println(e.getStackTrace()[0].getLineNumber()); // 28
			System.err.println(e.getStackTrace()[0].getFileName()); // Main.java
		}
	}

	// テスト
	public static void main(final String[] args) {
		Thread thread = new Thread(new Runnable() {
			public void run() {
				throw new IllegalArgumentException(); // 故意の例外発生
			}
		}, "Thread ID 1");
		thread.setUncaughtExceptionHandler(new MyExceptionHandler());
		thread.start();
	}
}