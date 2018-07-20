import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class D0720 {

    public static void main(String[] args) {
        Thread.UncaughtExceptionHandler handler = (Thread t, Throwable e) -> {
            System.out.println("thread-#####: " + t.getId() + "catch: " + e.getMessage());
        };
        ThreadFactory threadFactory = (Runnable r) -> {
            Thread t = new Thread(r);
            t.setUncaughtExceptionHandler(handler);
            return t;
        };

        // ExecutorService exec = Executors.newFixedThreadPool(1, threadFactory);
        // ExecutorService exec = Executors.newCachedThreadPool();

        // for(int i=0; i<5; i++) {
        //     exec.execute(new TestThread(i));
        // }
        // exec.shutdown();


        Runnable runnable = new TestThread(0);
        Thread thread = new Thread(runnable);
        thread.start();
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException...");
        }
        synchronized(runnable) {
            System.out.println("hello");
            runnable.notify();
        }

        

        // for(int i=0; i<5; i++) {
        //     new Thread(new TestThread(i)).start();
        // }
        // new Thread(new TestThread(100)).start();
    }
}

class TestThread implements Runnable {
    public final int id;
    public TestThread(int id) {
        this.id = id;
    }

    public synchronized void wake(){
        this.notify();
    }
    
    @Override
    public void run() {
        System.out.println("#" + this.id + "sleep...");
        try{
            synchronized (this) {
                this.wait();
            }
            System.out.println("unlock....");
        } catch (InterruptedException e) {
            System.out.println("[InterruptedException]" + "#" + this.id);
        }
        System.out.println("#" + this.id + "ok...");
    }
}

class myUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("thread-#####: " + t.getId() + "catch: " + e.getMessage());
        // while(true) {
        //     try {
        //         t.wait(2000);
        //     } catch (InterruptedException e1) {
        //         e1.printStackTrace();
        //     }
        // }
    }
    @Override
    public String toString() {
        return "hello"+super.toString();
    }
}