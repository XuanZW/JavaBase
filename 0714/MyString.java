import java.util.ArrayList;
import java.util.Arrays;

public class MyString {
    private final char[] value;

    public MyString() {
        this.value = new char[0];
    }

    public MyString(char value[]) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public MyString(String str) {
        this.value = Arrays.copyOf(str.toCharArray(), str.length());
    }

    /**
     * 获取字符串长度
     */
    public int length() {
        return this.value.length;
    }

    /**
     * 判断字符串是否为空
     */
    public boolean isEmpty() {
        return this.value.length == 0 ? true : false;
    }

    /**
     * 获取索引位置的char
     */
    public char charAt(int pos) {
        if(pos<0 || pos>this.value.length-1) {
            // throw StringIndexOutOfBoundsException(pos);
            System.out.println(pos + " 不在范围中");
            System.exit(1);
        }
        return this.value[pos];
    }

    // public byte[] getBytes() {
    //     byte[] des = 
    // }

    /**
     * 比较相等
     */
    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(getClass() == obj.getClass()) {
            MyString str = (MyString) obj;
            if(value.length == str.value.length) {
                int i = value.length-1;
                while(i-->=0) {
                    if(value[i] != str.value[i])
                        return false;
                }
                return true;
            }
        }
        return false;
    }

    /**
     * 比较是否相等，忽略大小写
     */
    public boolean equalsIgnoreCase(MyString anotherString) {
        if(value.length == anotherString.value.length) {
            anotherString = anotherString.toUpperCase();
            int i = value.length-1;
            while(i-->=0) {
                if(value[i]!=anotherString.value[i]) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    /**
     * 全部转换为大写
     */
    public MyString toUpperCase() {
        char[] chs = new char[value.length];
        for(int i=0; i<chs.length; i++) {
            if(value[i]>=97 && value[i]<=('a'+25))
                chs[i] = (char)(value[i]-32);
            else
                chs[i] = value[i];
        }
        return new MyString(chs);
    }

    /**
     * 转换为小写
     */
    public MyString toLowerCase() {
        char[] chs = new char[value.length];
        for(int i=0; i<chs.length; i++) {
            if(value[i]>=65 && value[i]<=('A'+25))
                chs[i] = (char)(value[i]+32);
            else
                chs[i] = value[i];
        }
        return new MyString(chs);
    }

    /**
     * 判断字符串是否以某个字符串开头
     */
    public boolean startsWith(MyString prefix) {
        int len = prefix.length();
        if(len <= this.value.length) {
            for(int i=0; i<len; i++) {
                if(prefix.value[i]!=value[i])
                    return false;
            }
            return true;
        }

        return false;
    }

    /**
     * 判断字符串是否以某个字符串结尾
     */
    public boolean endsWith(MyString suffix) {
        int len = suffix.length();
        if(len <= this.value.length) {
            for(int i=0; i<len; i++) {
                if(suffix.value[i]!=value[value.length-len+i])
                    return false;
            }
            return true;
        }

        return false;
    }

    /**
     * 返回该字符串第一次出现的位置
     */
    public int indexOf(MyString str) {
        if(str.length()>this.value.length)
            return -1;
        
        int i=0;
        int j=0;
        while(i < this.value.length) {
            while(i < this.value.length && str.value[0] != this.value[i]) 
                i++;
            if(i + str.length() > this.value.length)
                return -1;
            for(j=1; j < str.length() && (i+j) < this.value.length; j++) {
                if(str.value[j] != this.value[i+j])
                    break;
            }
            if(j == str.length())
                return i;
            i++;
        }

        return -1;
    }

    /**
     * (倒着查)返回该字符串第一次出现的位置
     */
    public int lastIndexOf(MyString str) {
        if(str.length()>this.value.length)
            return -1;
        
        int i = this.value.length-1;
        int j;
        while(i >= 0) {
            while(i >= 0 && str.value[0] != this.value[i])
                i--;
            if(i + str.length() > this.value.length)
                return -1;
            for(j=0; j < str.length() && (i+j) < this.value.length; j++) {
                if(str.value[j] != this.value[i+j])
                    break;
            }
            if(j == str.length())
                return i;
            i--;
        }

        return -1;
    }

    /**
     * 切割字符串
     */
    public MyString subString(int beginIndex, int endIndex) {
        char[] chs = new char[endIndex - beginIndex];
        System.arraycopy(value, beginIndex, chs, 0, chs.length);
        return new MyString(chs);
    }

    /**
     * 切割字符串
     */
    public MyString subString(int beginIndex) {
        return subString(beginIndex, this.value.length);
    }

    /**
     * 拼接字符串
     */
    public MyString concat(MyString str) {
        char[] chs = Arrays.copyOf(value, value.length+str.length());
        System.arraycopy(str.value, 0, chs, value.length, str.length());
        return new MyString(chs);
    }

    /**
     * 判断是否包含一个字符序列
     */
    public boolean contains(CharSequence s) {
        return indexOf(new MyString(s.toString())) > -1;
    }

    /**
     * 去掉两侧空格
     */
    public MyString trim() {
        char[] chs = Arrays.copyOf(value, value.length);
        int left = 0;
        int right = value.length-1;
        while(left < value.length && value[left++] == ' ');
        while(right >= 0 && chs[right--] == ' ');

        int len = right-left+1+2;
        char[] res = new char[len];
        System.arraycopy(chs, left-1, res, 0, len);

        return new MyString(res);
    }

    /**
     * 获取字符数组
     */
    public char[] toCharArray() {
        return Arrays.copyOf(value, value.length);
    }

    /**
     * 将一个数据转化为MyString类型
     */
    public static MyString valueOf(int data) {
        return new MyString(Integer.toString(data));
    }
    public static MyString valueOf(long data) {
        return new MyString(Long.toString(data));
    }
    public static MyString valueOf(boolean data) {
        return new MyString(Boolean.toString(data));
    }
    public static MyString valueOf(float data) {
        return new MyString(Float.toString(data));
    }
    public static MyString valueOf(double data) {
        return new MyString(Double.toString(data));
    }
    public static MyString valueOf(char data) {
        return new MyString(Character.toString(data));
    }

    /**
     * 字符串切割
     */
    public MyString[] split(MyString regex) {
        MyString tmp = this;
        ArrayList<MyString> list = new ArrayList<>();
        int index = -1;
        while((index = tmp.indexOf(regex)) != -1) {
            list.add(tmp.subString(0, index));
            if(index+1 == tmp.value.length)
                break;
            tmp = tmp.subString(index+1);
        }
        if(index == -1)
            list.add(tmp);

        System.out.println(list);
        return list.toArray(new MyString[]{});
    }


    @Override
    public String toString() {
        return new String(this.value);
    }


    public static void main(String[] args) {
        MyString str = new MyString("Hello World");
        // int index = str.lastIndexOf(new MyString("W"));
        // System.out.println(index);
        // System.out.println(str.subString(0));
        // System.out.println(str.concat(new MyString("ABC")));
        // System.out.println(str.trim());

        // for(char ch: str.toCharArray()) {
        //     System.out.println(ch);
        // }

        // str.split(new MyString(" "));
        // System.out.println((new MyString("World")).indexOf(new MyString("od")));
        // System.out.println((new MyString("rlld")).indexOf(new MyString("l")));
        // System.out.println((new MyString("rlld")).lastIndexOf(new MyString("l")));

        // for(MyString s: str.split(new MyString(" "))) 
        //     System.out.println(s);

        // ArrayList<Integer> list = new ArrayList<>();
        // list.add(1);
        // list.add(2);
        // list.add(3);
        // list.add(4);
        // for(int i: list.toArray(new Integer[]{})) {
        //     System.out.println(i);
        // }
    }
}