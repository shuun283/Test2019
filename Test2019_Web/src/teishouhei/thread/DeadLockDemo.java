package teishouhei.thread;

import java.util.Random;

public class DeadLockDemo implements Runnable{
    
   public boolean flag = false;
   
   public static Object o1 = new Object();
   public static Object o2 = new Object();
   
    public static void main(String[] args) {
        DeadLockDemo demo1 = new DeadLockDemo();
        DeadLockDemo demo2 = new DeadLockDemo();
        new Thread(demo1).start();
        
        demo2.flag = true;
        new Thread(demo2).start();
        new Random().nextInt(250);
    }

    @Override
    public void run() {
        while(true) {
            if (flag == false) {
                synchronized(o1) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println("o1 is locked");
                    synchronized(o2) {
                        System.out.println("o2 is needed");
                        
                        
                    }
                }
            } else {
                synchronized(o2) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println("o2 is locked");
                    synchronized(o1) {
                        System.out.println("o1 is needed");
                        
                        
                    }
                }
            }
        }
        
    }

}
