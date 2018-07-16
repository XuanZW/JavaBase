public class ClassDemo {
    public static void main(String[] args) {
        // A a = new C();
        // B b = (B) a;
        // System.out.println(a.getClass());
        // System.out.println(b.getClass());
        // A a = new A();
        // B b = new B();
        // System.out.println(B.class.getSuperclass().getSuperclass().getSuperclass());
        
        System.out.println(C.QAQ);
    }
}


class A {
    private String name = "A";

    public A() {
        // System.out.println("A is init...");
        // print();
    }

    public void print() {
        System.out.println("name is = " + name);
    }
}

class B extends A {
    private String name = "B";

    public B() {
        // System.out.println("B is init...");
        // print();
    }

    public void print() {
        super.print();
        System.out.println("name is = " + name);
    }
}

abstract class C {
    public static String QAQ = "AAA";
    
}
