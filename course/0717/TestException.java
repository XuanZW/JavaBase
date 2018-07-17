public class TestException {

    public static void main(String[] args) {
        try {
            post();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void post() {
        int x = 0;
        try {
            // x = 5/0;
            throw new Exception("just so so");
        } catch(Exception e) {
            System.out.println("¡¾cache¡¿"+e.getMessage());
        } finally {
            System.out.println("FFFF");
        }
    }
}