import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class D0721 {
    public static void main(String[] args) {
        
        TestCondition test = new TestCondition();

        Runnable run1 = () -> {
            while(true) {
                test.f1();
            }
        };
        
        Runnable run2 = () -> {
            while(true) {
                test.f2();
            }
        };

        new Thread(run1).start();
        new Thread(run2).start();
    }
}

class TestCondition {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean flag = true;

    public void f1() {
        lock.lock();
        try {
            if(this.flag) {
                Thread.sleep(500);
                System.out.println("f1() waitting ...");
                condition.await();
            } else {
                System.out.println("hehe..");
                this.flag = false;
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void f2() {
        lock.lock();
        try {
            if(!this.flag) {
                this.flag = true;
                Thread.sleep(3000);
                this.condition.signal();
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    
}
