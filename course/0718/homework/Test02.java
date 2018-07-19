import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * 将当前系统时间以"yyyy-MM-dd HH:mm:ss"格式输出
 * 
 *
 */
public class Test02 {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = new Date();
        String nowTime = sdf.format(date);
        System.out.println("当前时间: " + nowTime);
    }
}
