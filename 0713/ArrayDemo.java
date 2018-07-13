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
        
        
        // System.out.print("统计结果(最大值、最小值、平均值、总和): ");
        // printArr(statistics(arr));

        // System.out.print("排序前: ");
        // printArr(arr);
        // bubleSort(arr);
        // System.out.print("排序后: ");
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
     * 统计数组的最大值、最小值、平均值、总和
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
     * 输出数组
     */
    public static void printArr(int[] arr) {
        for(int i: arr)
            System.out.print(i+" ");
        System.out.println();
    }

    /**
     * 冒泡排序
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
     * 作业1：给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数，返回索引
     */
    public static void getTwoNumSum(int[] arr, int sum) {
        // 1.两次循环
        // for(int i=0; i<arr.length; i++) {
        //     for(int j=i+1; j<arr.length; j++) {
        //         if(arr[i]+arr[j]==sum) {
        //             System.out.println("["+(i+1)+", "+(j+1)+"]");
        //             return;
        //         }
        //     }
        // }
        // 2.一次循环
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
     * 作业2：给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
     */
    public static void moveZero(int[] arr) {
        // 1. 冒泡的方式
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
        // 2. 插入方式
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
     * 作业3：翻转字符串
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
     * 作业4：翻转单词
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
     * 作业5：
     * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
     * 使得 a + b + c = 0? 找出所有满足条件且不重复的三元组。
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
     * 作业6：将两个有序数组合并为一个有序数组，使用双指针
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