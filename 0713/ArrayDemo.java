import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ArrayDemo {
    public static void main(String[] args) {
        // int[] x = new int[0];
        
        // int[] arr = {1, 2, 3, 4, 5, 6, 6, 20, 21, 34, 77, 99, 66, 33};
        
        
        // System.out.print("ͳ�ƽ��(���ֵ����Сֵ��ƽ��ֵ���ܺ�): ");
        // printArr(statistics(arr));

        // System.out.print("����ǰ: ");
        // printArr(arr);
        // bubleSort(arr);
        // System.out.print("�����: ");
        // printArr(arr);   
        
        // System.out.println(reverseString("hello"));

        // getTwoNumSum(new int[]{2, 7, 11, 15}, 9);
        
        // moveZero(new int[]{0,1,0,3,12});

        // System.out.println(reverseWord("the    sky    is    blue"));

        // int[][] arr = threeNumSumIsZero(new int[] {-1, 0, 1, 2, -1, -4});
        // System.out.println("[");
        // for(int[] turple: arr) {
        //     System.out.print("  [ ");
        //     for(int elem: turple)
        //         System.out.print(elem+" ");
        //     System.out.println("]");
        // }
        // System.out.println("]");

        for(int elem: concatArray(new int[]{1,3,5,7}, new int[]{2,4,6,8}))
            System.out.print(elem+" ");
        System.out.println();
    }

    
    /**
     * ͳ����������ֵ����Сֵ��ƽ��ֵ���ܺ�
     */
    public static int[] statistics(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int avg = 0;
        int sum = 0;
        
        for(int i: arr) {
            if(i>max)
                max = i;
            if(i<min)
                min = i;
            sum += i;
        }
        avg = sum/arr.length;
        
        return new int[]{max, min, avg, sum};
    }

    /**
     * �������
     */
    public static void printArr(int[] arr) {
        for(int i: arr)
            System.out.print(i+" ");
        System.out.println();
    }

    /**
     * ð������
     */
    public static void bubleSort(int[] arr) {
        int temp;
        for(int i=0; i<arr.length-1; i++) {
            for(int j=0; j<arr.length-1; j++) {
                if(arr[j]>arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    /**
     * ��ҵ1������һ���Ѱ����������� ���������飬�ҵ�������ʹ���������֮�͵���Ŀ��������������
     */
    public static void getTwoNumSum(int[] arr, int sum) {
        // 1.����ѭ��
        // for(int i=0; i<arr.length; i++) {
        //     for(int j=i+1; j<arr.length; j++) {
        //         if(arr[i]+arr[j]==sum) {
        //             System.out.println("["+(i+1)+", "+(j+1)+"]");
        //             return;
        //         }
        //     }
        // }
        // 2.һ��ѭ��
        int left=0, right=arr.length-1;
        int tmp = 0;
        while(left<right) {
            tmp = arr[left]+arr[right];
            if(tmp == sum) {
                System.out.println("["+(left+1)+", "+(right+1)+"]");
                return;
            } else if(tmp < sum) {
                left++;
            } else {
                right--;
            }
        }
    }

    /**
     * ��ҵ2������һ������ nums����дһ������������ 0 �ƶ��������ĩβ��ͬʱ���ַ���Ԫ�ص����˳��
     */
    public static void moveZero(int[] arr) {
        // 1. ð�ݵķ�ʽ
        // int tmp;
        // int pos = arr.length;
        // for(int i=0; i<arr.length; i++) {
        //     if(arr[i] == 0)
        //         pos--;
        //     for(int j=0; j<pos; j++) {
        //         if(arr[j]==0 && arr[j+1]!=0) {
        //             tmp = arr[j];
        //             arr[j] = arr[j+1];
        //             arr[j+1] = tmp;
        //         }
        //     }
        // }
        // 2. ���뷽ʽ
        int right = arr.length-1;
        for(int i=0; i<right; i++) {
            if(arr[i] == 0) {
                for(int j=i; j<right; j++)
                    arr[j] = arr[j+1];
                arr[right] = 0;
                right--;
            }
        }
        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    /**
     * ��ҵ3����ת�ַ���
     */
    public static String reverseString(String str) {
        char[] chs = str.toCharArray();
        char tmp;
        for(int i=0; i<(chs.length/2); i++) {
            tmp = chs[i];
            chs[i] = chs[chs.length-1-i];
            chs[chs.length-1-i] = tmp;
        }
        
        return new String(chs);
    }

    /**
     * ��ҵ4����ת����
     */
    public static String reverseWord(String word) {
        String[] arr = word.trim().split("\\s+");
        String tmp;
        for(int i=0; i<arr.length/2; i++) {
            tmp = arr[i].trim();
            arr[i] = arr[arr.length-1-i].trim();
            arr[arr.length-1-i] = tmp;
        }
        StringBuilder sb = new StringBuilder();
        for(String str: arr)
            sb.append(str).append(" ");
        return sb.toString();
    }

    /**
     * ��ҵ5��
     * ����һ������ n ������������ nums���ж� nums ���Ƿ��������Ԫ�� a��b��c ��
     * ʹ�� a + b + c = 0? �ҳ��������������Ҳ��ظ�����Ԫ�顣
     */
    public static int[][] threeNumSumIsZero(int[] arr) {
        Set<Tuple> set = new HashSet<>();
        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                for(int k=j+1; k<arr.length; k++) {
                    if(arr[i]+arr[j]+arr[k] == 0) {
                        int[] tmp = {arr[i], arr[j], arr[k]};
                        Arrays.sort(tmp);
                        set.add(new Tuple(tmp[0], tmp[1], tmp[2]));
                    }
                }
            }
        }

        int[][] ret = new int[set.size()][3];
        List<Tuple> list = new ArrayList<>(set);
        for(int i=0; i<list.size(); i++) {
            ret[i][0] = list.get(i).f1;
            ret[i][1] = list.get(i).f2;
            ret[i][2] = list.get(i).f3;
        }
            
        return ret;
    }

    /**
     * ��ҵ6����������������ϲ�Ϊһ���������飬ʹ��˫ָ��
     */
    public static int[] concatArray(int[] arr1, int[] arr2) {
        int[] ret = new int[arr1.length+arr2.length];
        int p1 = 0;
        int p2 = 0;
        for(int i=0; i<ret.length; i++) {
            if(p1>=arr1.length)
                ret[i] = arr2[p2++];
            else if(p2>=arr2.length)
                ret[i] = arr1[p1++];
            else 
                if(arr1[p1]<arr2[p2])
                    ret[i] = arr1[p1++];
                else
                    ret[i] = arr2[p2++];
        }
        return ret;
    }

}

class Tuple {
    public int f1;
    public int f2;
    public int f3;
    public Tuple(int f1, int f2, int f3) {
        this.f1 = f1;
        this.f2 = f2;
        this.f3 = f3;
    }
    @Override
    public int hashCode() {
        return Integer.parseInt((new StringBuilder()).append(this.f1>0?this.f1:-this.f1)
                .append(this.f2>0?this.f2:-this.f2)
                .append(this.f3>0?this.f3:-this.f3).toString());
    }
    @Override
    public boolean equals(Object obj) {
        Tuple t = (Tuple)obj;
        return this.f1==t.f1 && this.f2==t.f2 && this.f3==t.f3;
    }
}