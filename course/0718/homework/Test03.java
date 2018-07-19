import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Date;

/**
 * 输入某人生日，格式为"yyyy-MM-dd"，输出到现在为止经过了多少周。
 * 
 *
 */
public class Test03 {
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入生日(年-月-日): ");
        String birth = in.next();
        in.close();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sdf.parse(birth));

        Calendar c2 = Calendar.getInstance();
        c2.setTime(new Date());
        
        int year = calendar.get(Calendar.YEAR);
        int nowYear = c2.get(Calendar.YEAR);
        int count = 0;
        if(year != nowYear) {
            count = calendar.getWeeksInWeekYear() - calendar.get(Calendar.WEEK_OF_YEAR);
            while(year < nowYear) {
                calendar.set(Calendar.YEAR, year++);
                count += calendar.getWeeksInWeekYear();
            }
        } else {
            count = c2.get(Calendar.WEEK_OF_YEAR) - calendar.get(Calendar.WEEK_OF_YEAR);
        }
        
        System.out.println("已过去 " + count + " 周")   ;
    }
}
