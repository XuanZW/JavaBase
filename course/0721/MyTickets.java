import java.util.LinkedList;
import java.util.Queue;

public class MyTickets {
    public static void main(String[] args) {

        TicketWindow window = new TicketWindow();
        
        new Thread(new Producer(window)).start();
        new Thread(new Consumer(window)).start();


    }
}

class TicketWindow {
    private int ticketNums = 100;
    private int no = 0;
    private int hadSale = 0;
    private Queue<Integer> queue = new LinkedList<Integer>();
    private int maxQueueNum = 10;

    public synchronized void producer() throws InterruptedException {
        if(queue.size() <= maxQueueNum) {
            queue.add(++no);
            System.out.println("��" + no + "���˿�ʼ�Ŷ�");
            this.notifyAll();
            if(!this.haveTicket()){
                saleOut();
            }
        } else {
            System.out.println("�Ŷӵ��˹����ˣ��Ȼ������...");
            this.wait();
        }
    }

    public synchronized void consumer() throws InterruptedException {
        if(this.queue.size() > 0) {
           if(this.hadSale < this.ticketNums) {
               System.out.println("��"+ queue.poll() +"������Ʊ����");
               hadSale++;
               this.notifyAll();
               
               if(!this.haveTicket()){
                    saleOut();
               }
           } else {
                saleOut();
           }
        } else {
            System.out.println("���ڿ����ˣ���������Ʊ...");
            this.wait();
        }
    }

    public synchronized boolean haveTicket() {
        return this.ticketNums > this.hadSale ? true : false;
    }
    
    public synchronized boolean havaConsumer() {
        return queue.size() > 0;
    }

    private void saleOut() {
        System.out.println("Ʊ������...");
        while(!this.queue.isEmpty())
            System.out.println("��"+ queue.poll() +"����û��Ʊ����������");
    }
}

class Producer implements Runnable {
    private TicketWindow window;

    public Producer(TicketWindow window) {
        this.window = window;
    }
        
    @Override
    public void run() {
        while(true) {
            if(!window.haveTicket())
                break;
            try {
                Thread.sleep(50);
                window.producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class Consumer implements Runnable {
    private TicketWindow window;

    public Consumer(TicketWindow window) {
        this.window = window;
    }

    @Override
    public void run() {
        while(true) {
            if(!window.haveTicket())
                break;
            try {
                Thread.sleep(50);
                window.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}