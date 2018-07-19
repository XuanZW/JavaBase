import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

/**
 * 实现时间的计算: 要求用户输入身份证号，若格式有误，要求其重新输入。然后根据身份证号码输出20岁生日
 * 所在周的周三的日期。
 * 例如:
 * 出生日期:1992-07-15。
 * 20岁生日:2012-07-15
 * 当周的周三为:2012-07-18
 * 
 *
 */
public class Test05 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.print("请输入身份证号: ");
            String id = in.next();
            if(id.length() < 18) {
                System.err.println("输入的身份证号有误，请重新输入");
                continue;
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            try {  
                System.out.println(id.substring(6, 14));
                c.setTime(sdf.parse(id.substring(6, 14)));
            } catch (Exception e) {
                System.out.println("输入的身份证号有误，请重新输入");
                continue;
            }
            System.out.println("出生日期: "+ sdf2.format(c.getTime()));
            c.set(Calendar.YEAR, c.get(Calendar.YEAR)+20);
            System.out.println("20岁生日: "+ sdf2.format(c.getTime()));
            c.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
            System.out.println("当周周三: "+ sdf2.format(c.getTime()));
            break;
        }

        in.close();
    }
}
