import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Date;

/**
 * 输入一个生产日期格式"yyyy-MM-dd",再输入一个数字(保质期的天数)。
 * 然后经过计算输出促销日期，促销日期为:该商品过期日前2周的周三
 * 
 *
 */
public class Test04 {
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        String produceDate = in.next();
        int preserve = in.nextInt();
        in.close();
        

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(produceDate));
        c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR) + preserve);
        c.set(Calendar.WEEK_OF_YEAR, c.get(Calendar.WEEK_OF_YEAR) - 2);
        c.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
        System.out.println(sdf.format(c.getTime()));
    }
}
