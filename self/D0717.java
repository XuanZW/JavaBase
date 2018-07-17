import java.util.*;
import java.util.concurrent.*;

public class D0717 {

    public static void main(String[] args) {

        // ExecutorService exec = Executors.newCachedThreadPool();
        ExecutorService exec = Executors.newFixedThreadPool(1);
        ArrayList<Future<String>> results = new ArrayList<>();
        for(int i=0; i<10; i++) {
            results.add(exec.submit(new TaskWithResult(i)));
        }
        for(Future<String> fs : results) {
            try {
                // System.out.println(fs.get());
            } catch(Exception e) {
                e.printStackTrace();
            } finally {
                exec.shutdown();
            }
        }
    }
    
}


class TaskWithResult implements Callable<String> {
    private int id;
    public TaskWithResult(int id) {
        this.id = id;
    }
    @Override
    public String call() throws Exception {
        for(int i=0; i<100; i++) {
            try {
                System.out.println("[#"+id+"] "+i);
                Thread.yield();
                Thread.sleep(10); 
                Thread.currentThread().setPriority(5);
                // Thread.MAX_PRIORITY;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "result of TaskWithResult " + this.id;
    }
}