package shuun.chapte8;

import java.util.concurrent.Callable;

public class TestLogic implements Callable<Long> {
	private int id;
	private long start;

	public TestLogic(int id, long start) {
        this.id = id;
        this.start = start;
    }

	@Override
	public Long call() throws Exception {
		System.out.println("run(" + id + ")#begin - " + Thread.currentThread().getId());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		long time = System.currentTimeMillis() - start;
		System.out.println("run(" + id + ")#end - " + time + ", " + Thread.currentThread().getId());
		return time;
	}
}