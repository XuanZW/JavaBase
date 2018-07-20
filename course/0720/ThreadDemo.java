public class ThreadDemo {
    public static void main(String[] args) {

        Runnable run1 = () -> {
            while(true)
                System.out.println("hhhhhhhhh");
        };
        Runnable run2 = () -> {
            while(true)
                System.out.println("ggggggggg");
        };
        
        new Thread(run1).start();
        new Thread(run2).start();
        
    }
}