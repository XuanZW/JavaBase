import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class D0714 {
    public static void main(String... args) throws IOException {

        /**
         * DataOutputStream д�ļ�
         */
        // DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File("./test.dat")));
        // dos.writeUTF("��UTF-8�ķ�ʽ�������ݣ�����ƽ̨���ļ���Ӱ��");
        // dos.close();

        /**
         * DataInputStream ���ļ�
         */
        // DataInputStream dis = new DataInputStream(new FileInputStream(new File("./test.dat")));
        // String str = dis.readUTF();
        // dis.close();
        // System.out.println(str);

        /**
         * ��д��������ļ�
         */
        // RandomAccessFile raf = new RandomAccessFile(new File("./test.dat"), "rw");
        // raf.seek(raf.length()-Integer.parseInt(args[0]));
        // // raf.writeChars("Q");
        // raf.writeBytes("Q");
        // raf.close();

        /**
         * StringBuilder �� StringBuffer �̰߳�ȫ�ԱȽ�
         */
        // for(int i=0; i<5; i++) {
        //     new Thread() {
        //         public void run() {
        //             StringBuilder sb = new StringBuilder();
        //             sb.append("A");
        //             sb.append("B");
        //             sb.append("C");
        //             sb.append("D");
        //             sb.append("E");
        //             System.out.println("Builder -> "+sb.toString());
        //         }
        //     }.start();
        // }
        // for(int i=0; i<5; i++) {
        //     new Thread() {
        //         public void run() {
        //             StringBuilder sb = new StringBuilder();
        //             sb.append("A");
        //             sb.append("B");
        //             sb.append("C");
        //             sb.append("D");
        //             sb.append("E");
        //             System.out.println("Buffer -> "+sb.toString());
        //         }
        //     }.start();
        // }
        
        // StringBuilder sb1 = new StringBuilder();
        // StringBuffer sb2 = new StringBuffer();
        // for(int i=0; i<10; i++) {
        //     new A(sb1, sb2).start();
        // }

        // final StringBuilder sb1 = new StringBuilder();
        // final StringBuffer sb2 = new StringBuffer();

        // final Tread outThread = new Thread() {
        //     @Override
        //     public void run() {
                
        //     }
        // };

        // for(int i=0; i<5; i++) {
        //     final int num = i;
        //     new Thread() {
        //         public void run() {
        //             for(int i=0; i<2; i++) {
        //                 char ch = (char)('A'+num*2+i);
        //                 // System.out.println(num+":"+i+"("+(num*2+i)+") -> "+ch);
        //                 sb1.append(ch);
        //             }
        //         }
        //     }.start();
        // }
        // for(int i=0; i<5; i++) {
        //     final int num = i;
        //     new Thread() {
        //         public void run() {
        //             for(int i=0; i<2; i++) {
        //                 char ch = (char)('A'+num*2+i);
        //                 sb2.append(ch);
        //             }
        //         }
        //     }.start();
        // }

        // try {
        //     Thread.sleep(1000);
        // } catch(InterruptedException e) {
        //     e.printStackTrace();
        // }
        // System.out.println("Der: "+sb1.toString());
        // System.out.println("Fer: "+sb2.toString());


        /**
         * ����I/O�ٶȣ�ʹ��ͨ��(FileChanner)�ͻ�����(ByteBuffer)
         * Ψһֱ����ͨ�������Ļ�������ByteBuffer
         * I/O�����������������ڲ���ͨ����FileInputStream/FileOutputaStream/RandomAccessFile
         */
        // RandomAccessFile raf = new RandomAccessFile(new File("./test.dat"), "rw");
        // FileChannel fc = raf.getChannel();
        // fc.position(fc.size());
        // fc.write(ByteBuffer.wrap("some more".getBytes()));
        // ByteBuffer buffer = ByteBuffer.allocate(1024);
        // fc.read(buffer);
        // fc.close();
        // raf.close();
        
        // // ��ô�棬FileOutputStream���ļ�ȫ����ˣ�ʲôҲû�ˣ���Ҫͬʱ��һ���ļ�
        // FileInputStream fis = new FileInputStream(new File("./test.dat"));
        // FileOutputStream fos = new FileOutputStream(new File("./test.dat"));
        // FileChannel in = fis.getChannel();
        // FileChannel out = fos.getChannel();
        // ByteBuffer buff = ByteBuffer.allocate(1024);
        // while(in.read(buff) != -1) {
        //     String content = buff.asCharBuffer().toString(); // ��Ϊ�ַ���ȡ
        //     buffer.flip(); // ׼��д����
        //     out.write(buff);
        //     buffer.clear(); // ��ջ�������׼��������
        // }
        // in.close();
        // out.close();
        // fis.close();
        // fos.close();


    }

    /**
     * ��InputStream�ж�ȡ�ַ���������
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

class A extends Thread {
    private StringBuilder builder;
    private StringBuffer buffer;
    public A(StringBuilder builder, StringBuffer buffer) {
        this.builder = builder;
        this.buffer = buffer;
    }
    public void run() {
        for(int i=0; i<100; i++) {
            builder.append('d');
            buffer.append('d');
            try {
                Thread.sleep(10);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("[" + Thread.currentThread().getName() + "] builder:" + builder.length());
        System.out.println("[" + Thread.currentThread().getName() + "] buffer:" + buffer.length());
    }
}