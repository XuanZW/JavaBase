import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class D0714 {
    public static void main(String... args) throws IOException {

        /**
         * DataOutputStream 写文件
         */
        // DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File("./test.dat")));
        // dos.writeUTF("以UTF-8的方式保存数据，忽略平台对文件的影响");
        // dos.close();

        /**
         * DataInputStream 读文件
         */
        // DataInputStream dis = new DataInputStream(new FileInputStream(new File("./test.dat")));
        // String str = dis.readUTF();
        // dis.close();
        // System.out.println(str);

        /**
         * 读写随机访问文件
         */
        // RandomAccessFile raf = new RandomAccessFile(new File("./test.dat"), "rw");
        // raf.seek(raf.length()-Integer.parseInt(args[0]));
        // // raf.writeChars("Q");
        // raf.writeBytes("Q");
        // raf.close();

        /**
         * StringBuilder 和 StringBuffer 线程安全性比较
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
         * 提升I/O速度，使用通道(FileChanner)和缓冲器(ByteBuffer)
         * 唯一直接与通道交互的缓冲器是ByteBuffer
         * I/O类库中有三个类可用于产生通道，FileInputStream/FileOutputaStream/RandomAccessFile
         */
        // RandomAccessFile raf = new RandomAccessFile(new File("./test.dat"), "rw");
        // FileChannel fc = raf.getChannel();
        // fc.position(fc.size());
        // fc.write(ByteBuffer.wrap("some more".getBytes()));
        // ByteBuffer buffer = ByteBuffer.allocate(1024);
        // fc.read(buffer);
        // fc.close();
        // raf.close();
        
        // // 这么玩，FileOutputStream把文件全清空了，什么也没了，不要同时打开一个文件
        // FileInputStream fis = new FileInputStream(new File("./test.dat"));
        // FileOutputStream fos = new FileOutputStream(new File("./test.dat"));
        // FileChannel in = fis.getChannel();
        // FileChannel out = fos.getChannel();
        // ByteBuffer buff = ByteBuffer.allocate(1024);
        // while(in.read(buff) != -1) {
        //     String content = buff.asCharBuffer().toString(); // 作为字符读取
        //     buffer.flip(); // 准备写数据
        //     out.write(buff);
        //     buffer.clear(); // 清空缓存区，准备读数据
        // }
        // in.close();
        // out.close();
        // fis.close();
        // fos.close();


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