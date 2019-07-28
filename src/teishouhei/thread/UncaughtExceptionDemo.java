package teishouhei.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UncaughtExceptionDemo implements Runnable{

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool(new MyThreadFacotry());
        try {
            exec.execute(new UncaughtExceptionDemo());
        } catch (Exception e) {
            System.out.println("main thread " + e.getMessage());
        } finally {
            exec.shutdown();
        }
    }

    @Override
    public void run() {
        throw new RuntimeException("thread exception");
    }

}
