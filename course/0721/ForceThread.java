public class ForceThread {

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            for(int i=0; i<100; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }, "凶猛的撒旦");
        
        Thread thread2 = new Thread(() -> {
            for(int i=0; i<100; i++) {
                if(i == 3) {
                    try {
                        thread1.join();
                    } catch(InterruptedException e) {
                        System.out.println("撒旦被大天使带走了...");
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }, "待宰的羔羊");

        thread2.start();
        thread1.start();
    }

}