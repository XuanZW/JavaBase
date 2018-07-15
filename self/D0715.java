import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.util.Enumeration;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class D0715 {

    public static void main(String[] args) throws IOException {
        /**
         * 使用映射速度更快、不用加载全部文件即可读取修改文件
         */
        // RandomAccessFile raf = new RandomAccessFile("./test.tmp", "rw");
        // FileChannel fc = raf.getChannel();
        // IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
        // // ib.allocate(1024);
        // for(int i=0; i<10; i++) {
        //     System.out.println("aaaaaaaaaaaaaa");
        //     ib.put(i);
        // }
        // fc.close();
        // raf.close();

        // FileChannel fc = new RandomAccessFile("/temp.tmp", "rw").getChannel();
        // IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
        // for(int i=0; i<10; i++)
        //     ib.put(i);
        // fc.close();


        /**
         * 文件压缩 - GZIP
         */
        // 写入
        // writeGZIP(new File("test.tmp"), new File("test.gz"));
        // 读取
        // readGZIP(new File("test.gz"));

        /**
         * 文件压缩 - ZIP
         */
        // 写入
        // writeZip(new File("test.zip"), new File[]{new File("c1.txt"), new File("c2.txt")});
        // 提取
        // readZip(new File("test.zip"));

        /**
         * 枚举测试
         */
        // for(Signal s: Signal.values()) {
        //     System.out.println(s);
        // }
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

enum Signal {
    GREEN(2001, "aa"),
    YELLOW(2002, "bb"),
    RED(2003, "cc");

    private int state;
    private String description;
    private Signal(int state, String description) {
        this.state = state;
        this.description = description;
    }
    public int getValue() {
        return this.state;
    }
    public String getDescription() {
        return this.description;
    }
    @Override
    public String toString() {
        return this.name()+" - "+this.state+"("+description+")";
    }
}


@interface Test {

}