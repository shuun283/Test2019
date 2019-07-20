package shuun.chapte8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class NewFixedThreadPool {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(3);
		long start = System.currentTimeMillis();
		Object[] futures = new Object[5];
		for (int i = 0; i < 5; i++) {
			System.out.println("main(" + i + ")#submit - " + Thread.currentThread().getId());
			futures[i] = exec.submit(new TestLogic(i, start));
		}
		for (int i = 0; i < 5; i++) {
			Future<Long> future = (Future<Long>) futures[i];
			try {
				long time = future.get(500, TimeUnit.MILLISECONDS);
				System.out.println("main(" + i + ")#get - " + time + ", " + Thread.currentThread().getId());
			} catch (TimeoutException e) {
				System.out.println("main(" + i + ")#get - TIMEOUT, " + Thread.currentThread().getId());
				i--;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		exec.shutdown();
	}
}