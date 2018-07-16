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

    /**
     * 文件压缩 - GZIP 写入压缩文件
     */
    public static void writeGZIP(File inputFile, File outputFile) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(inputFile));
        BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(outputFile)));
        System.out.println("开始压缩");
        int c;
        while((c = in.read()) != -1)
            out.write(c);
        System.out.println("压缩完成");
        in.close();
        out.close();
    }

    /**
     * 文件压缩 - GZIP 读取压缩文件
     */
    public static void readGZIP(File inputFile) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(inputFile))));
        String s;
        while((s = in.readLine()) != null)
            System.out.println(s); 
        in.close();
    }

    /**
     * 文件压缩 - Zip 写入
     */
    public static void writeZip(File zipFile, File[] files) throws IOException {
        FileOutputStream f = new FileOutputStream(zipFile);
        CheckedOutputStream csum = new CheckedOutputStream(f, new Adler32());
        ZipOutputStream zos = new ZipOutputStream(csum);
        BufferedOutputStream out = new BufferedOutputStream(zos);
        BufferedReader in = null;
        int c;
        zos.setComment("Java 使用Zip压缩多文件测试");
        for(File file: files) {
            in = new BufferedReader(new FileReader(file));
            zos.putNextEntry(new ZipEntry(file.getName()));
            while((c = in.read()) != -1)
                out.write(c);
            in.close();
            out.flush();
        }
        out.close();
        System.out.println("压缩完成");
        // 在文件关闭后获取校验文件的校验和
        System.out.println("Checksum: " + csum.getChecksum().getValue());
    }

    /**
     * 文件压缩 - Zip 提取文件
     */
    public static void readZip(File zipFile) throws IOException {
        FileInputStream fis = new FileInputStream(zipFile);
        CheckedInputStream csumi = new CheckedInputStream(fis, new Adler32());
        ZipInputStream zis = new ZipInputStream(csumi);
        BufferedInputStream bis = new BufferedInputStream(zis);
        ZipEntry ze = null;
        int len;
        byte[] bytes = new byte[1024];
        StringBuilder sb = null;
        while((ze = zis.getNextEntry()) != null) {
            // System.out.println("read file: " + ze);
            sb = new StringBuilder();
            while((len = bis.read(bytes)) != -1) {
                sb.append(new String(bytes, 0, len));   
            }
            // 转换为字符串并输出
            System.out.println(sb.toString());
        }
        bis.close();
        // 在文件关闭后获取校验文件的校验和
        System.out.println("Checksum: " + csumi.getChecksum().getValue());
        System.out.println("---------------------------");

        // 获取Zip文件的另一种方式
        ZipFile zf = new ZipFile("test.zip");
        Enumeration e = zf.entries();
        while(e.hasMoreElements()) {
            ZipEntry ze2 = (ZipEntry)e.nextElement();
            System.out.println("File: " + ze2);
        }
    }
}

/**
 * 模拟JUnit实现单元测试
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Test {}

/**
 * @Test注解处理器
 */
class TestProcessor {
    public static void process(Class cl) {
        try {
            Object obj = cl.newInstance();
            for(Method method: cl.getDeclaredMethods()) {
                // System.out.println("--> "+method.getName());
                Annotation[] anns = method.getDeclaredAnnotations();
                if(anns.length < 1)
                    continue;
                if(anns[0] instanceof Test) {
                    System.out.println("==== [Testing]: " + method.getName() + " ====");
                    try {
                        method.invoke(obj);
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }

            System.out.println("==== you have passed this test. ====");
        } catch(InstantiationException|IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}