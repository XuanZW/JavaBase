/**
 * 复习JavaSE过程中总结的部分工具方法
 */
public class Utils {

    /**
     * 移动：134、135、136、137、138、139、147、148、150、151、152、157、158、
     *     159、172、178、182、183、184、187、188、198，
     * 联通：130、131、132、145、146、155、156、166、171、175、176、185、186，
     * 电信：133、149、153、173、174、177、180、181、189、199，
     * 全球星：1349，
     * 虚拟运营商：170
     */
    private static final String PHONE_PATTERN = "^1((3\\d)|(4[5-9])|(5[^4])|(66)|(7[^9])|(8\\d)|(9[8,9]))\\d{8}$";
    /**
     * 校验是否是手机号
     */
    public static boolean isMobile(CharSequence phone) {
        return Pattern.matches(PHONE_PATTERN, phone);
    }

    /**
     * 名称和域名只允许英文字母、数字、下划线、以及中划线组成
     */
    private static final String EMAIL_PATTERN_1 = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
    /**
     * 名称允许汉字、字母、数字，域名只允许英文域名
     */
    private static final String EMAIL_PATTERN_2 = "^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
    /**
     * 校验是否是邮箱
     */
    public static boolean isEmail(CharSequence email) {
        return Pattern.matches(EMAIL_PATTERN_1, email) || Pattern.matches(EMAIL_PATTERN_2, email);
    }

    
    /**
     * 从InputStream中读取字符串并返回
     */
    public static String streamToString(InputStream in) throws IOException {
        StringBuilder sb = new StringBuilder();
        byte[] bys = new byte[1024];
        int len = 0;
        while((len=in.read(bys)) != -1) {
            sb.append(new String(bys, 0, len));
        }

        return sb.toString();
    }


}