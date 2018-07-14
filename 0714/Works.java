import java.util.*;

public class Works {

    public static void main(String[] args) {
        int[][] arr = fourNumSumIsZero(new int[] {-1, 0, 1, 2, -1, -4});
        System.out.println("[");
        for(int[] turple: arr) {
            System.out.print("  [ ");
            for(int elem: turple)
                System.out.print(elem+" ");
            System.out.println("]");
        }
        System.out.println("]");
    }

    public static int[][] fourNumSumIsZero(int[] arr) {
        Set<Tuple> set = new HashSet<>();
        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                for(int k=j+1; k<arr.length; k++) {
                    for(int l=k+1; l<arr.length; l++) {
                        if(arr[i]+arr[j]+arr[k] == 0) {
                            int[] tmp = {arr[i], arr[j], arr[k], arr[l]};
                            Arrays.sort(tmp);
                            set.add(new Tuple(tmp[0], tmp[1], tmp[2], tmp[3]));
                        }
                    }
                }
            }
        }

        int[][] ret = new int[set.size()][4];
        List<Tuple> list = new ArrayList<>(set);
        for(int i=0; i<list.size(); i++) {
            ret[i][0] = list.get(i).f1;
            ret[i][1] = list.get(i).f2;
            ret[i][2] = list.get(i).f3;
            ret[i][3] = list.get(i).f4;
        }
            
        return ret;
    }
}

class Tuple {
    public int f1;
    public int f2;
    public int f3;
    public int f4;
    public Tuple(int f1, int f2, int f3, int f4) {
        this.f1 = f1;
        this.f2 = f2;
        this.f3 = f3;
        this.f4 = f4;
    }
    @Override
    public int hashCode() {
        return Integer.parseInt((new StringBuilder()).append(this.f1>0?this.f1:-this.f1)
                .append(this.f2>0?this.f2:-this.f2)
                .append(this.f3>0?this.f3:-this.f3)
                .append(this.f4>0?this.f4:-this.f4).toString());
    }
    @Override
    public boolean equals(Object obj) {
        Tuple t = (Tuple)obj;
        return this.f1==t.f1 && this.f2==t.f2 && this.f3==t.f3 && this.f4==t.f4;
    }
}