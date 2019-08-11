package teishouhei.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadSafeTest implements Runnable{
    
    volatile int i = 0;
    
//    AtomicInteger atomic = new AtomicInteger(0);
//   
//    
//    private ReentrantLock lock = new ReentrantLock();
//    
//    Object o1 = new Object();

    public static void main(String[] args) {
        ThreadSafeTest tst = new ThreadSafeTest();
        //ExecutorService exec = Executors.newCachedThreadPool();
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 1000; i++) {
            exec.execute(tst); 
        }
        exec.shutdown();
       

    }

    @Override
    public void run() {
//        synchronized(this) {
//            ++i;
//        }
//        lock.lock();
//        try {
            method();            
//        } finally {            
//            lock.unlock();
//        }
//        atomic.incrementAndGet();
//        atomic.compareAndSet(1, 2);
            System.out.println(i);

    }
    
//    public synchronized void method() {
//        ++i;
//    }
    
        public void method() {
            ++i;
            // Thread.yield();
            //++i;
        }

}

