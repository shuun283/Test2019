package teishouhei.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class DaemonFactoryTest implements Runnable{

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool(new MyDaemonFacotry());
        exec.execute(new DaemonFactoryTest());
        exec.shutdown();

    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " is end!");        
    }

}

class MyDaemonFacotry implements ThreadFactory {

    @Override
    public Thread newThread(Runnable arg0) {
        Thread t = new Thread(arg0);
        t.setDaemon(true);
        return t;
    }

}


