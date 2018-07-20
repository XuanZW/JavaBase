import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;;

public class ProducerAndCustomer {

    public static void main(String[] args) {
        List<Integer> cache = new ArrayList<Integer>();

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
        try {
            TimeUnit.SECONDS.sleep(5);
            exec1.shutdownNow();
            TimeUnit.SECONDS.sleep(1);
            exec2.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class Producer implements Runnable {
    private final int id;
    private List<Integer> cache;
    
    public Producer(int id, List<Integer> cache) {
        this.id = id;
        this.cache = cache;
    }

    @Override
    public void run() {
        while(true) {
            this.write();
        }
    }

    public void write() {
        synchronized (cache) {
            int pos = cache.size();
            int data = new Random().nextInt(100);
            System.out.println("[Writer#" + id + "]  write in [ " + pos + ", " + data + " ]");
            cache.add(data);
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch(InterruptedException e) {
                System.out.println("[Writer#" + id + "]  occur Exception...");
                e.printStackTrace();
            }
        }
    }
}

class Customer implements Runnable {
    private final int id;
    private List<Integer> cache;
    
    public Customer(int id, List<Integer> cache) {
        this.id = id;
        this.cache = cache;
    }

    @Override
    public void run() {
        while(true) {
            this.read();
        }
    }

    public void read() {
        synchronized (cache) {
            if(cache.size() == 0)
                return;
            System.out.println("[Reader#" + id + "]  read  in [ 0, " + cache.get(0) + " ]");
            cache.remove(0);
            try {
                TimeUnit.MILLISECONDS.sleep(150);
            } catch(InterruptedException e) {
                System.out.println("[Writer#" + id + "]  occur Exception...");
                e.printStackTrace();
            }
        }
    }
}