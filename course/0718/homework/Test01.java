import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 使用Date输出当前系统时间，以及3天后这一刻的时间
 * 
 *
 */
public class Test01 {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = new Date();
        String nowTime = sdf.format(date);
        System.out.println("当前时间: " + nowTime);

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH)+3);
        date = c.getTime();
        String afterTime = sdf.format(date);
        System.out.println("三天后时间: " + afterTime);
    }
}
