package teishouhei.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest extends Thread {
    
    public void run() {
//        try {
//            //Thread.sleep(1);
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        System.out.println(Thread.currentThread().getName() + " : running");
    }

    public static void main(String[] args) {
        
        ThreadTest t = new ThreadTest();
        t.start();
        //t.run();
        System.out.println(Thread.currentThread().getName() + " : running");
        
        Thread t2 = new Thread(new Runtest());
        t2.start();
        
        // スレッドプール
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++) {
            exec.execute(new Runtest());
        }
        
        exec.shutdown();
        
//        ExecutorService exec = Executors.newFixedThreadPool(2);
//        for (int i = 0; i < 5; i++) {
//            exec.execute(new Runtest());
//        }
    }

}

class Runtest implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " : running");
    }
    
}
