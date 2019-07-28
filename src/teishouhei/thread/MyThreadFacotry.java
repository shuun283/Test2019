package teishouhei.thread;

import java.util.concurrent.ThreadFactory;

public class MyThreadFacotry implements ThreadFactory{

    @Override
    public Thread newThread(Runnable arg0) {
        Thread t = new Thread(arg0);
        t.setUncaughtExceptionHandler(new MyUncaughtException());
        return t;
    }


}
