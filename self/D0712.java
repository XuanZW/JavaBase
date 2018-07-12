import java.util.Formatter;
import java.util.Random;
import java.util.regex.Pattern;

public class D0712 {

    public static void main(String[] args) {
        // �ַ�����ʽ��
        // int a = 8;
        // System.out.println(new Formatter().format("%o", a));

        // ������ʽ
        // System.out.println("1234".matches("-?\\d"));
        
        // �����ֻ���
        // Random rand = new Random();
        // StringBuilder sb = null;
        // int[] arrs = {134,135,136,137,138,139,147,148,150,151,152,157,158,159,172,178,182,183,184,187,188,198,130,131,132,145,146,155,156,166,171,175,176,185,186,133,149,153,173,174,177,180,181,189,199,170};
        // for(int str: arrs) {
        //     sb = new StringBuilder();
        //     sb.append(str);
        //     for(int i=0; i<8; i++)
        //         sb.append(rand.nextInt(10));
        //     System.out.println(sb.toString()+": "+isMobile(sb.toString()));
        // }

        // ��������
        // String[] strs = {"8573@qq.com", "s_cns--2ds31@ww.ad.dadawsd.da", "qqqqq@qda.qw.sa.com", "����@sd.aadw.aq1.ac"};
        // for(String str: strs)
        //     System.out.println(str+": "+isEmail(str));
        
    }

    /**
     * �ƶ���134��135��136��137��138��139��147��148��150��151��152��157��158��
     *     159��172��178��182��183��184��187��188��198��
     * ��ͨ��130��131��132��145��146��155��156��166��171��175��176��185��186��
     * ���ţ�133��149��153��173��174��177��180��181��189��199��
     * ȫ���ǣ�1349��
     * ������Ӫ�̣�170
     */
    // 3-(\\d) 4-(5-9) 5(^4) 6(6) 7(^9) 8(\\d) 9([8,9])
    private static final String PHONE_PATTERN = "^1((3\\d)|(4[5-9])|(5[^4])|(66)|(7[^9])|(8\\d)|(9[8,9]))\\d{8}$";
    // private static final String PHONE_PATTERN = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$";
    /**
     * У���Ƿ����ֻ���
     */
    public static boolean isMobile(CharSequence phone) {
        return Pattern.matches(PHONE_PATTERN, phone);
    }

    /**
     * ���ƺ�����ֻ����Ӣ����ĸ�����֡��»��ߡ��Լ��л������
     */
    private static final String EMAIL_PATTERN_1 = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
    /**
     * ���������֡���ĸ�����֣�����ֻ����Ӣ������
     */
    private static final String EMAIL_PATTERN_2 = "^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";

    /**
     * У���Ƿ�������
     */
    public static boolean isEmail(CharSequence email) {
        return Pattern.matches(EMAIL_PATTERN_1, email) || Pattern.matches(EMAIL_PATTERN_2, email);
    }
}