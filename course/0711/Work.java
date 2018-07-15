import java.util.*;

/**
 * 当晚作业
 * @author CN
 * @Date 2018-07-11 20:23
 */
public class Work {
    public static void main(String[] args) {
        

        pringTriangle(5);

        System.out.println();
        pringReverseTriangle(5);

        System.out.println(fib(15));
        
        printOddAndEven(100);
    }

    /**
     * 正等边三角形
     */
    public static void pringTriangle(int height) {
        for(int i=1; i<=height; i++) {
            for(int j=0; j<(height-i); j++)
                System.out.print(" ");
            for(int k=0; k<i*2-1; k++)
                System.out.print("*");
            System.out.println();
        }
    }

    /**
     * 倒等边三角形
     */
    public static void pringReverseTriangle(int height) {
        for(int i=1; i<=height; i++) {
            for(int j=0; j<(i-1); j++)
                System.out.print(" ");
            for(int k=0; k<(height-i+1)*2-1; k++)
                System.out.print("*");
            System.out.println();
        }
    }

    /**
     * 输出奇偶数
     */
    public static void printOddAndEven(int num) {
        List<Integer> odd = new LinkedList<Integer>();
        List<Integer> even = new LinkedList<Integer>();
        for(int i=0; i<=num; i++) {
            if(i%2==0)
                even.add(i);
            else
                odd.add(i);
        }
        Iterator it = odd.iterator();
        System.out.println("奇数：");
        while(it.hasNext())
            System.out.print(it.next()+" ");

        it = even.iterator();
        System.out.println("\n偶数：");
        while(it.hasNext())
            System.out.print(it.next()+" ");
    }

    /**
     * 斐波那契数列
     */
    public static int fib(int n) {
        if(n==1 || n==2)
            return 1;
        return fib(n-1)+fib(n-2);
    }
}