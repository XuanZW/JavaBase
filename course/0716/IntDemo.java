public class IntDemo implements USBA, USBB {
    public static void main(String[] args) {
        USBA usba = new IntDemo();
        USBB usbb = new IntDemo();
        
        usba.work();
        usbb.work();
        usbb.print();
    }

    public void work() {
        System.out.println("working...");
    }
}

interface USBA {
    public int ars = 1;
    public void work();
}

interface USBB {
    public void work();
    
    public default void print() {
        System.out.println("OK");
    };
}
