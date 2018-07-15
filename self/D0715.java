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
         * ʹ��ӳ��ķ�ʽ��д���ļ����ٶ����ܸ���
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
         * �ļ�ѹ�� - GZIP
         */
        // д��ѹ���ļ�
        // writeGZIP(new File("test.tmp"), new File("test.gz"));
        // ��ȡѹ���ļ�
        // readGZIP(new File("test.gz"));

        /**
         * �ļ�ѹ�� - ZIP
         */
        // д��
        writeZip(new File("test.zip"), new File[]{new File("c1.txt"), new File("c2.txt")});
        // ��ȡ
        readZip(new File("test.zip"));
    }

    /**
     * �ļ�ѹ�� - GZIP д��ѹ���ļ�
     */
    public static void writeGZIP(File inputFile, File outputFile) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(inputFile));
        BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(outputFile)));
        System.out.println("��ʼѹ��");
        int c;
        while((c = in.read()) != -1)
            out.write(c);
        System.out.println("ѹ�����");
        in.close();
        out.close();
    }

    /**
     * �ļ�ѹ�� - GZIP ��ȡѹ���ļ�
     */
    public static void readGZIP(File inputFile) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(inputFile))));
        String s;
        while((s = in.readLine()) != null)
            System.out.println(s); 
        in.close();
    }

    /**
     * �ļ�ѹ�� - Zip д��
     */
    public static void writeZip(File zipFile, File[] files) throws IOException {
        FileOutputStream f = new FileOutputStream(zipFile);
        CheckedOutputStream csum = new CheckedOutputStream(f, new Adler32());
        ZipOutputStream zos = new ZipOutputStream(csum);
        BufferedOutputStream out = new BufferedOutputStream(zos);
        BufferedReader in = null;
        int c;
        zos.setComment("Java ʹ��Zipѹ�����ļ�����");
        for(File file: files) {
            in = new BufferedReader(new FileReader(file));
            zos.putNextEntry(new ZipEntry(file.getName()));
            while((c = in.read()) != -1)
                out.write(c);
            in.close();
            out.flush();
        }
        out.close();
        System.out.println("ѹ�����");
        // ���ļ��رպ��ȡУ���ļ���У���
        System.out.println("Checksum: " + csum.getChecksum().getValue());
    }

    /**
     * �ļ�ѹ�� - Zip ��ȡ�ļ�
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
            // ת��Ϊ�ַ��������
            System.out.println(sb.toString());
        }
        bis.close();
        // ���ļ��رպ��ȡУ���ļ���У���
        System.out.println("Checksum: " + csumi.getChecksum().getValue());
        System.out.println("---------------------------");

        // ��ȡZip�ļ�����һ�ַ�ʽ
        ZipFile zf = new ZipFile("test.zip");
        Enumeration e = zf.entries();
        while(e.hasMoreElements()) {
            ZipEntry ze2 = (ZipEntry)e.nextElement();
            System.out.println("File: " + ze2);
        }
    }

}