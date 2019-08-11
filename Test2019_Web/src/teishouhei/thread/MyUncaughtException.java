package teishouhei.thread;

public class MyUncaughtException implements Thread.UncaughtExceptionHandler{

    @Override
    public void uncaughtException(Thread t, Throwable exception) {
        System.out.println(exception.getMessage());
    }

}
