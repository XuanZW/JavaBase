import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class D0719 {

    public static void main(String[] args) {
        // AttemptLocking attemptLocking = new AttemptLocking();
        // attemptLocking.unuseTime();
        // attemptLocking.useTime();

        // new TestIPlus().run();

        // ExecutorService exec = Executors.newCachedThreadPool();
        // for(int i=0; i<5; i++) {
        //     exec.execute(new Accessor(i));
        // }
        // exec.shutdown();
        
        ExecutorService exec = Executors.newFixedThreadPool(1, new ThreadFactory(){
        
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setUncaughtExceptionHandler(new myUncaughtExceptionHandler());
                return t;
            }
        });
        for(int i=0; i<5; i++) {
            exec.execute(new TestThread(i));
        }
        exec.shutdown();
    }
}

class TestThread implements Runnable {
    public final int id;
    public TestThread(int id) {
        this.id = id;
    }
    
    @Override
    public void run() {
        while(true) {
            System.out.println("#" + this.id + "sleep...");
            try{
                this.wait(2000);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("[InterruptedException]" + "#" + this.id);
            }
            System.out.println("#" + this.id + "ok...");
        }
    }
}

class myUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("thread-#####: " + t.getId() + "catch: " + e.getMessage());
        while(true) {
            try {
                t.wait(2000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
    }
    @Override
    public String toString() {
        return "hello"+super.toString();
    }
}

class MultiLock {
    public synchronized void f1(int count) {
        if(count-- > 0) {
            System.out.println("f1() calling f2() with count " + count);
            f2(count);
        }
    }
    public synchronized void f2(int count) {
        if(count-- > 0) {
            System.out.println("f2() calling f1() with count " + count);
            f1(count);
        }
    }
    public static void main(String[] args) {
        final MultiLock multiLock = new MultiLock();
        new Thread() {
            public void run() {
                multiLock.f1(10);
            }
        }.start();
    }
}

class ThreadLocalVariableHolder {
    private static ThreadLocal<Integer> val = new ThreadLocal<Integer>() {
        private Random rand = new Random(47);
        protected Integer initialValue() {
            return rand.nextInt(1000);
        }
    };
    public static void increment() {
        val.set(val.get() + 1);
    }
    public static Integer getValue() {
        return val.get();
    }
}
class Accessor implements Runnable {
    private final int id;
    public Accessor(int id) {
        this.id = id;
    }
    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()) {
            // ThreadLocalVariableHolder.increment();
            System.out.println(this);
        }
    }
    @Override
    public String toString() {
        return "#" + id + ": " + ThreadLocalVariableHolder.getValue();
    }
}


class TestIPlus {
    private AtomicInteger val;
    public void run() {
        for(int i=0; i<10; i++) {
            this.val = new AtomicInteger(0);
            final CountDownLatch count = new CountDownLatch(10000);
            for(int j=0; j<100; j++) {
                new Thread(){
                    @Override
                    public void run() {
                        for(int i=0; i<100; i++) {
                            TestIPlus.this.val.getAndIncrement();
                            count.countDown();
                        }
                    }
                }.start();
            }
            try {
                count.await();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.val);
        }
    }
}

class AttemptLocking {
    private ReentrantLock lock = new ReentrantLock();

    public void useTime() {
        boolean isLocked = false;
        try {
            isLocked = lock.tryLock(1, TimeUnit.SECONDS);
        } catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            if(isLocked) {
                System.out.println("(Yes) I get the lock.");
            } else
                System.out.println("(Yes) I can't lock it.");
        } finally {
            if(isLocked)
                lock.unlock();
        }
    }

    public void unuseTime() {
        boolean isLocked = false;
        try {
            isLocked = lock.tryLock();
            System.out.println("(No) I get the lock.");
            
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            if(isLocked)
                lock.unlock();
        }
    }
}