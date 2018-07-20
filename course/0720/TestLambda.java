public class TestLambda {

    public static void main(String[] args) {
        
        Print print = (String msg) -> {
            System.out.println(msg);
        };

        print.print("hello world");
        
    }

}

interface Print {
    public void print(String str);
}