import java.util.LinkedList;
import java.util.Queue;

public class Tickets {

    public static void main(String[] args) {
        
        WindowQueue queue=new WindowQueue();
        
		Producer p=new Producer(queue);
		Consumer con=new Consumer(queue);
		//以上的代码一定要注意 传入的是同一个对象
		
		Thread t1=new Thread(p);
		Thread t2=new Thread(con);
		
		t1.start();
		t2.start();
    }
}

class WindowQueue { //卖票的窗口

	//定义卖票队列
	int maxSize=10;
	Queue<Integer> queue = new LinkedList<Integer>();
	int num=0; //最多卖100张票
	boolean flag=true ; //判断是否继续卖票
	
	
	//排队买票
	public synchronized void producer()throws Exception{
		if(this.queue.size()<maxSize) {
			this.queue.add(num++); //等待买票的数量++
			System.out.println("第"+num+"个客户排队买票");
			this.notifyAll(); //唤醒等待的线程
		} else {
			System.out.println("队列已满 请等待");
			this.wait(); 
		}
	}
	
	
	//卖票
	public synchronized void consumer()throws Exception{
		if(this.queue.size() > 0) {
			int temp = this.queue.remove();//出队
            System.out.println("第"+(temp+1)+"个客户买到票离开队列");
            
			//如果当前的队列为空 并且卖出票数大于100
			if(this.queue.isEmpty()&&this.num>=100) {
				this.flag=false;
			}
			this.notifyAll(); //唤醒等待的线程
		}else {
			
			System.out.println("队列已空 请等待(没有的买票的人，去哪卖票呢？)");
			this.wait();
		}
	}
}

class Producer implements Runnable{

	WindowQueue queue;
	
	public Producer(WindowQueue queue) {
		
		this.queue=queue;
	}
	
	@Override
	public void run() {
		while(queue.num<100) {  //必须小于100张票 才可以买票
		try {
			Thread.sleep(1000);
			queue.producer();
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	}

}

class Consumer implements Runnable{
	
	WindowQueue queue;
	
	public Consumer(WindowQueue queue) {
		
		this.queue=queue;
	}
	
	@Override
	public void run() {
		while(queue.flag) {  //如果队列为空 并且票数大于100 就不会卖票了
			try {
				Thread.sleep(1000);
				queue.consumer();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}



