import java.util.*;
import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) throws Exception {
        
        // FutureTask<String> ft = new FutureTask<String>(new MyThread());
        // new Thread(ft).start();
        // System.out.println("-----");
        // System.out.println(ft.get()); // 会阻塞进程，等待线程返回
        // System.out.println("-----");

        // Thread t = new Thread("hello") {
        //     @Override
        //     public void run() {
        //         ;
        //         System.out.println(Thread.currentThread().getName());
        //     }
        // };
        // // t.setName("hello");
        // t.start();

        
        Runnable runnable = () -> {
            try {
                Thread.sleep(1000);
                // TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("over");
        };

        new Thread(runnable).start();
    }
}

class MyThread implements Callable<String> {
    @Override
    public String call() throws Exception {
        for(int i=0; i<10; i++) {
            System.out.println("running " + i);
        }

        Thread.sleep(2000);

        return "over";
    }
}