package teishouhei.thread;

public class ExceptionTest implements Runnable {

    public static void main(String[] args) {
        try {
            // ExceptionTest.method();
            new Thread(new ExceptionTest()).start();
        } catch (Exception e) {
            System.out.println("main thread " + e.getMessage());
        }
    }

    @Override
    public void run() {
        throw new RuntimeException("Thread Exception");
    }

    public static void method() {
        throw new RuntimeException("Normal Exception");
    }

}
