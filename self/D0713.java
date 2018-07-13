import java.util.*;
import java.util.regex.Pattern;
import java.io.*;

public class D0713 {
    public static void main(String... args) throws IOException {
        /** Set���� */
        // Set<Node> set = null;
        // ��֤��������
        // set = new TreeSet<Node>();
        // ���򣨸��ݹ�ϣֵ�洢��
        // set = new HashSet<Node>();
        // ��֤����˳��
        // set = new LinkedHashSet<Node>();
        // set.add(new Node(2));
        // set.add(new Node(7));
        // set.add(new Node(4));
        // set.add(new Node(3));
        // set.add(new Node(1));
        // System.out.println(set);

        /** ���ȶ��� */
        // Queue<Node> q = new PriorityQueue<Node>();
        // q.addAll(Arrays.asList(new Node(8), new Node(4), new Node(12), new Node(3), new Node(5), new Node(2)));
        // System.out.printsln(q);
        // q.clear();
        // q.add(new Node(8));
        // q.add(new Node(3));
        // q.add(new Node(12));
        // q.add(new Node(4));
        // q.add(new Node(5));
        // q.add(new Node(2));
        // ʹ�����ȶ��еĵ���˳�򣨲���������˳�򣩺����γ��ӵ�˳��ͬ
        // System.out.println(q);
        // while(!q.isEmpty())
        //     System.out.print(q.poll()+" ");
        // System.out.println();

        /** Mapʵ�� */
        // Map<Node, Integer> map = null;
        // Ĭ��HashMap �Ż�����(�ȱȽ�hashCode������ͬ�Ƚ�equals)
        // map = new HashMap<Node, Integer>();
        // ��֤���ܣ�ͬʱ��֤����˳�򣬵����ٶȸ���
        // map = new LinkedHashMap<>();
        // �����ʵ�֣���֤������
        // map = new TreeMap<>();
        // WeakHashMap - ��ӳ����������ָ��������ɱ���������
        // ConcurrentHashMap - �̰߳�ȫ��ӳ��
        // IdentityHashMap - ʹ��==����equals()�Ƚϼ�
        // map.put(new Node(44, 12), 44);
        // map.put(new Node(44, 13), 34);
        // map.put(new Node(64, 14), 64);
        // map.put(new Node(12), 12);
        // map.put(new Node(8), 8);
        // System.out.println(map);

        /**
         * == �Ƚϵ��� ���õ�ַ�Ƿ���ͬ
         * equals ��equals�ķ���ֵ��
         */
        // Node n1 = new Node(1);
        // Node n2 = new Node(2);
        // n1.code = 3;
        // n2.code = 3;
        // System.out.println(n1 == n2);
        // System.out.println(n1.equals(n2));

        /** contains ����ʹ����indexOf indexOf �õ�equals���αȽ� */
        // List<Node> list = new ArrayList<Node>(10);
        // list.add(new Node(2));
        // System.out.println(list.contains(new Node(1)));

        /** ����hashCode���÷��� */
        // int code;
        // // boolean
        // boolean f1 = true; 
        // code = f1 ? 0 : 1;
        // // byte short int 
        // int f2 = 12;
        // code = f2;
        // // long 
        // long f3 = Integer.MAX_VALUE+1L;
        // code = (int)(f3 ^ f3 >>> 32);
        // // float
        // float f4 = 1.0f;
        // code = Float.floatToIntBits(f4);
        // // double
        // double f5 = 222.131313;
        // long tmp = Double.doubleToLongBits(f5);
        // code = (int)(tmp ^ (tmp >>> 32));
        
        /** �������� */
        // List<Node> list = new ArrayList<Node>(10);
        // list.addAll(Arrays.asList(new Node[]{new Node(8), new Node(4), new Node(12), new Node(3), new Node(5), new Node(2)}));
        // System.out.println(list);
        // Collections.sort(list);
        // System.out.println(list);
        // Collections.sort(list, new ReverseComparator());
        // System.out.println(list);

        /** �����̰߳�ȫ */
        // List<Node> list = Collections.synchronizedList(new ArrayList<Node>());
        // List<Node>  list = new ArrayList<Node>();
        // boolean[] res = new boolean[5];
        // for(int i=0; i<5; i++) {
        //     final int num = i;
        //     new Thread() {
        //         @Override
        //         public void run() {
        //             for(int i=0; i<5; i++) {
        //                 list.add(new Node(i, num));
        //             }
        //             res[num] = true;
        //         }
        //     }.start();
        // }
        // while(true) {
        //     if(res[0] && res[1] && res[2] && res[3] && res[4]) {
        //         System.out.println(list);
        //         System.out.println(list.size());
        //         break;
        //     }
        // }


        /** I/O */
        // Test File.class
        // �ļ���������
        // class DirFilter implements FilenameFilter {
        //     @Override
        //     public boolean accept(File dir, String name) {
        //         return Pattern.matches("^[A-Za-z][a-zA-Z0-9]+.java$", name);
        //     }
        // }
        // File file = new File(".");
        // List<File> dirs = new ArrayList<File>(file.list().length);
        // List<File> files = new ArrayList<File>(file.list().length);
        // for(File f: file.listFiles(new DirFilter())) {
        //     if(f.isFile())
        //         files.add(f);
        //     else if(f.isDirectory())
        //         dirs.add(f);
        // }        
        // for(File f: dirs)
        //     System.out.println("+"+f.getName());
        // for(File f: files)
        //     System.out.println("-"+f.getName());

        /**
         * ���������ļ�
         * ��һ���ļ������ַ����룬����ʹ�� FileInputReader
         * ����ٶ�ʹ�� BufferReader
         */
        // BufferedReader bfr = new BufferedReader(new FileReader(new File(".")));
        // bfr.readLine();

        /**
         * ��������ļ�
         */
        // BufferedWriter bfw = new BufferedWriter(new FileWriter(new File(".")));
        // bfw.write("this is output content...");

        
    }
}

class Node implements Comparable {
    public int val;
    public int code;
    public Node(int val) {
        this.val = val;
    }
    public Node(int val, int code) {
        this.val = val;
        this.code = code;
    }
    @Override
    public String toString() {
        return String.valueOf(this.code+"-"+this.val);
    }
    @Override
    public int compareTo(Object o) {
        return this.val-((Node)o).val;
    }
    @Override
    public int hashCode() {
        System.out.println("-- hashCode() --");
        return code;
    }
    @Override
    public boolean equals(Object obj) {
        System.out.println("-- equals() --");
        return this.val == ((Node)obj).val;
    }
}

class ReverseComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        return ((Node)o2).val-((Node)o1).val;
    }
}