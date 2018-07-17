public class A implements B {
	public static void main(String args[]) {
		int m, n;
		A a = new A();
		m = a.K;
		n = B.K;
		System.out.println(m + ", " + n);
	}
	@Override
	void a() {
		
	}
}
interface B {
	int K = 5;
	void a();
}
