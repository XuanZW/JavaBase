import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Util {
    public static void main(String[] args) throws Exception {
        // 单例模式
        // Runtime runtime = Runtime.getRuntime();
        // System.out.println("max  " + (double)runtime.maxMemory()/1024/1024/1024 + "GB");
        // System.out.println("use  " + (double)runtime.totalMemory()/1024/1024 + "MB");
        // System.out.println("free " + (double)runtime.freeMemory()/1024/1024 + "MB");
        
        // System.out.println(System.getenv("JAVA_HOME"));
        // System.out.println(System.nanoTime());

        // int[] arr = new int[20];
        // Arrays.fill(arr, 10);
        // System.out.println(Arrays.toString(arr));
        
        // A a1 = new A(20);
        // A a2 = (A) a1.clone();
        // System.out.println(a1 == a2);
        // System.out.println(a1);
        // System.out.println(a2);
        // System.out.println("-------------");
        // a2.val = 10;
        // System.out.println(a1);
        // System.out.println(a2);
    }
}


// class Com implements Comparator {
//     @Override
//     public int compare(Object o1, Object o2) {
//         return 0;
//     }
// }

class A implements Cloneable {
    public int val;
    A() {}
    A(int val) {
        this.val = val;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return new A(this.val);
    }
    @Override
    public String toString() {
        return ""+val;
    }
}