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
    }

    /**
     * 正对等三角形
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
     * 倒立对等三角形
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
     * 求解斐波那契数列
     */
    public static int fib(int n) {
        if(n==1 || n==2)
            return 1;
        return fib(n-1)+fib(n-2);
    }
}