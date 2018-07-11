import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class D0711 {
    public static void main(String[] args) {
        // Arrays - 输出数组
        // int[] arr = new int[10];
        // System.out.println(Arrays.toString(arr));


        // List list = Arrays.asList(1, 1.1, 'A');
        // for(Object o: list)
        //     System.out.println(o);
        // System.out.println(list);

        
        List<Node> list = new ArrayList<Node>();
        list.add(new Node(1));
        list.add(new Node(2));
        list.add(new Node(3));
        list.add(new Node(4));
        list.add(new Node(5));
        // List<Node> sub = list.subList(1, 4);
        // sub.get(0).value = 9;
        // System.out.println(sub);
        // System.out.println(list);
        // List<Node> copy = new ArrayList<>(sub);
        // copy.get(1).value = 22;
        // System.out.println(sub);
        // System.out.println(copy);

        // Iterator<Node> it = list.iterator();
        // while(it.hasNext()) {
        //     Node tmp = it.next();
        //     System.out.println(tmp);
        //     if(tmp.value == 3)
        //         it.remove();
        // }
        
        Node n1 = new Node(1);
        Node n2 = new Node(1);
        Set<Node> set = new HashSet<Node>();
        set.add(n1);
        set.add(n2);
        System.out.println(set);
    }
}

class Node {
    public Integer value;
    public Node(Integer value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    @Override
    public int hashCode() {
        System.out.println("11111");
        System.out.println(value.hashCode());
        return value.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        System.out.println("22222");
        return false;
    }
}