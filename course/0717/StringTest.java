public class StringTest {
    public static void main(String[] args) {
        String str = "�ó���Ա�����ݰ�20180717";
        String date = str.substring(str.indexOf("2"));
        System.out.println("����ʱ��: " + date);

        // String id = args[0];
        String id = "14262319970602";
        String birth = id.substring(6, 14);
        System.out.println("����: "+birth);
    }
}