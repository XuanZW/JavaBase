public class FuncDemo {
    public static void main(String[] args) {
        
        // System.out.println(add(1, 2));

        // System.out.println(add(1.1, 2.2));
        
        // System.out.println(add(100));
        
        // System.out.println(jiecheng(10));
        
        // System.out.println(fib(6));
    }

    /**
     * ���쳲���������
     */
    public static int fib(int n) {
        if(n==1 || n==2)
            return 1;
        return fib(n-1)+fib(n-2);
    }

    /**
     * �ۼ�
     */
    public static int add(int num) {
        if(num == 1)
            return 1;
        return num + add(num-1);
    }

    /**
     * �׳�
     */
    public static int jiecheng(int num) {
        if(num==2)
            return 2;
        return num*jiecheng(num-1);
    }

    /**
     * ��������-�������
     */
    public static int add(int a, int b) {
        return a+b;
    }

    /**
     * ��������-���������
     */
    public static double add(double a, double b) {
        return a+b;
    }
}