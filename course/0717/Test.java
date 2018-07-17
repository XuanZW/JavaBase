public class Test {
    public static void main(String[] args) {
        // String s = " ";
        // String tmp = s.trim();
        // System.out.println(tmp);
        // int res = tmp.substring(s.lastIndexOf(' ')+1).trim().length();
        // System.out.println(res);

        String a = "11";
        String b = "1";
        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();
        int len = Math.max(aa.length, bb.length);
        boolean isAdd = false;
        char res = '0';
        StringBuilder sb = new StringBuilder();
        char aaa, bbb;
        
        for(int i=len-1; i>=0; i--) {
            if()
            if(aa[i] == '1') {
                if(bb[i] == '1') {
                    if(isAdd) {
                        res = '1';
                        isAdd = true;
                    } else {
                        res = '0';
                    }
                } else {
                    
                }
            }
            if(aa[i] == '1' && bb[i] == '1') {
                if(isAdd)
                    res = '1';
                else 
                    res = '0';
                isAdd = true;
            } else if(aa[i]=='1' || bb[i]=='1') {
                if(isAdd) {
                    res = '0';
                    isAdd = true;
                } else {
                    res = '1';
                    isAdd = false;
                }
            } else {
                res = isAdd ? '1' : '0';
                isAdd = false;
            }
            sb.append(res);
        }
        if(aa.length == len)
            for(int i=len-1; i<bb.length; i++)
                sb.append(bb[i]);
        else
            for(int i=len-1; i<aa.length; i++)
                sb.append(aa[i]);
        sb.reverse();
     
        System.out.println(sb.toString());
    }
}