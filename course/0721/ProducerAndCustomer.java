import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;;

public class ProducerAndCustomer {

    public static void main(String[] args) {
        DataCache cache = new DataCache();
        
        ExecutorService exec1 = Executors.newCachedThreadPool();
        ExecutorService exec2 = Executors.newCachedThreadPool();
        for(int i=0; i<5; i++) {
            exec1.execute(new Producer(i, cache));
        }
        for(int i=0; i<5; i++) {
            exec2.execute(new Customer(i, cache));
        }
        exec1.shutdown();
        exec2.shutdown();

        // Thread t1 = new Thread(new Producer(0, cache));
        // Thread t2 = new Thread(new Customer(9, cache));
        // t1.start();
        // t2.start();

        // try {
        //     TimeUnit.SECONDS.sleep(5);
        //     exec1.shutdownNow();
        //     TimeUnit.SECONDS.sleep(1);
        //     exec2.shutdownNow();
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
    }

}

class DataCache {
    public int[] datas = new int[10];
    public int inPointer = 0; // 写入位置指针
    public int outPointer = 0; // 读取位置指针
    public int order = 0; // 测试使用，用于生成有序的数据

    // 翻转标记，当写指针先走到缓冲区的末尾时，回到为缓冲区的初始位置，
    // 复用已被读过的空间，此时打开翻转标记。当读指针走到缓冲区的末尾时，
    // 也回到缓冲区的初始位置，关闭翻转标记。
    public boolean reverse = false;
}

class Producer implements Runnable {
    private final int id;
    private DataCache cache;
    
    public Producer(int id, DataCache cache) {
        this.id = id;
        this.cache = cache;
    }

    /** 执行方法：循环执行写操作 */
    @Override
    public void run() {
        while(true) {
            try {
                this.write();
            } catch (InterruptedException e) {
                System.out.println("[@Writer #" + id + " ]  is interrupted...");
            }
        }
    }

    /** 写操作，找到合适的写的位置，并写入数据 */
    public void write() throws InterruptedException {
        synchronized (this.cache) {
            if(this.cache.inPointer < this.cache.datas.length) {
                if(this.cache.reverse) {
                    if(this.cache.inPointer < this.cache.outPointer)
                        writeData();
                    else
                        this.cache.wait();
                } else {
                    writeData();
                }
            } else {
                this.cache.reverse = true;
                this.cache.inPointer = 0;
                if(this.cache.outPointer > 0) {
                    writeData();
                } else {
                    this.cache.wait();
                }
            }
        }
    }

    /** 写入数据 */
    public void writeData() {
        int pos = this.cache.inPointer++;
        int data = this.cache.order++;
        this.cache.datas[pos] = data;
        synchronized (this.cache) {
            this.cache.notifyAll();
        }
        System.out.println("[Writer #" + id + " ]  write in [ " + pos + ", " + data + " ]");
        try {
            synchronized(this) {
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            System.out.println("[Writer #" + id + " ]  is interrupted...");
        }
    }
}

class Customer implements Runnable {
    private final int id;
    private DataCache cache;
    
    public Customer(int id, DataCache cache) {
        this.id = id;
        this.cache = cache;
    }

    /** 执行方法：循环执行读操作 */
    @Override
    public void run() {
        while(true) {
            try {
                this.read();
            } catch (InterruptedException e) {
                System.out.println("[@Reader #" + id + " ]  is interrupted...");
            }
        }
    }

    /** 读操作，找到合适的读的位置，并读出数据 */
    public void read() throws InterruptedException {
        synchronized (this.cache) {
            if(this.cache.outPointer < this.cache.datas.length) {
                if(this.cache.reverse) {
                    readData();
                } else {
                    if(this.cache.outPointer < this.cache.inPointer)
                        readData();
                    else
                        this.cache.wait();
                }
            } else {
                this.cache.reverse = false;
                this.cache.outPointer = 0;
                if(this.cache.inPointer > 0)
                    readData();
                else
                    this.cache.wait();
            }
        }
    }

    /** 读出数据 */
    public void readData() {
        int pos = this.cache.outPointer++;
        int data = this.cache.datas[pos];
        System.out.println("[Reader #" + id + " ]  read in [ " + pos + ", " + data + " ]");
        synchronized (this.cache) {
            this.cache.notifyAll();
        }
        try {
            synchronized(this) {
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            System.out.println("[Reader #" + id + " ]  is interrupted...");
        }
    }
}