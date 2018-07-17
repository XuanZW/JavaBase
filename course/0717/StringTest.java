public class StringTest {
    public static void main(String[] args) {
        String str = "好程序员大数据版20180717";
        String date = str.substring(str.indexOf("2"));
        System.out.println("开班时间: " + date);

        // String id = args[0];
        String id = "14262319970602";
        String birth = id.substring(6, 14);
        System.out.println("生日: "+birth);
    }
}