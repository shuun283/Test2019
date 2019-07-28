package teishouhei.thread;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest implements Callable<Integer>{
    
    private int id;
    
    public CallableTest(int id) {
        this.id = id;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        
        int result = 0;
        long start = System.currentTimeMillis();
        ArrayList<Future<Integer>> results = new ArrayList<Future<Integer>>();
        
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            results.add(exec.submit(new CallableTest(i)));
        }
        exec.shutdown();
        for (Future<Integer> fi : results) {
            result = result + fi.get();
        }
        long end = System.currentTimeMillis();
        System.out.println("time : " + (end - start));
        System.out.println(result);

    }

    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        return id;
    }

}
