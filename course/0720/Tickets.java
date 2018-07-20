import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tickets {
    public static void main(String[] args) {
        
        TicketThread tt = new TicketThread();

        for(int i=0; i<100; i++) {
            new Thread(tt).start();
        }
    }
}


class TicketThread implements Runnable {
    private Integer count = 1000;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while(true) {
            lock.lock();
            try {
                if(count <= 0)
                    break;
                System.out.println("sale ticke " + count--);
            } finally {
                lock.unlock();
            }
        }
    }
}