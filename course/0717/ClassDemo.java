public class ClassDemo {
    public int x;
    public ClassDemo() {}
    public ClassDemo(int y) {
        x = y;
    }
    // public void test() {
    //     ClassDemo demo = this(11);
    //     System.out.println("----->" + x);
    //     System.out.println("----->" + x);
    // }

    // 静态变量不可以定义在局部代码块中
    // public void fun() {
	// 	static int i = 0;
	// 	i++;
	// 	System.out.println(i);
	// }
	// public static void main(String args[]) {
	// 	Demo d = new Demo();
	// 	d.fun();
	// }
        
}