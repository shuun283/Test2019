package teishouhei.thread;

public class DaemonTest {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new DaemonThread(1));
        t.setDaemon(true);
        t.start();
        Thread.sleep(3000);
    }

}

class DaemonThread implements Runnable {
    
    private int id;

    public DaemonThread(int id) {
        this.id = id;
    }
    
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(id + " is end!");
    }
    
}