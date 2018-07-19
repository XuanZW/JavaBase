import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class D0718 {
    public static void main(String[] args) {
        // ExecutorService exec = Executors.newCachedThreadPool(new CacheExceptionThreadFactory());
        // exec.execute(new Thread() {
        //     @Override
        //     public void run() {
        //         System.out.println("R线程名: " + getId());
        //         System.out.println("R: " + currentThread().getUncaughtExceptionHandler().toString());
        //         throw new RuntimeException("给你个异常瞧瞧");
        //     }
        // });
        // exec.shutdown();

        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i=0; i<10; i++) {
            exec.execute(new A(IntGenerator.getIntGenerator(), i));
        }
        exec.shutdown();
    }
}

class A implements Runnable {
    private final int id;
    private IntGenerator g;
    public A(IntGenerator g, int id) {
        this.g = g;
        this.id = id;
    }
    
    @Override
    public void run() {
        while(!g.isCanceled) {
            int tmp = g.next();
            System.out.println("[#"+this.id+"] "+tmp);
            if(tmp%2 != 0) {
                System.out.println("[#"+this.id+"] 不是偶数 " + tmp);
                g.isCanceled = true;
            }
        }
    }
}
class IntGenerator {
    public volatile boolean isCanceled = false;
    private int x  = 0;
    private static IntGenerator g = new IntGenerator();

    private IntGenerator(){}

    public synchronized int next() {
        this.x++;
        this.x++;
        Thread.currentThread().interrupt();
        return x;
    }

    public static IntGenerator getIntGenerator() {
        return g;
    }
}

class myUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("E线程名: " + t.getId() + "异常: " + e.getMessage());
    }
    @Override
    public String toString() {
        return "哈哈"+super.toString();
    }
}

class CacheExceptionThreadFactory implements ThreadFactory {
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setUncaughtExceptionHandler(new myUncaughtExceptionHandler());
        return t;
    }
}



