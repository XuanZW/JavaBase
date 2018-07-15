public class Hello {
	
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		System.out.println(".___  .__                              ____.                    ");
        System.out.println("|   | |  |   _______  ____  _  __     |    |____ ___  _______   ");
        System.out.println("|   | |  |  /  _ \\  \\/ /\\ \\/ \\/ /     |    \\__  \\\\  \\/ /\\__  \\  ");
        System.out.println("|   | |  |_(  <_> )   /  \\     /  /\\__|    |/ __ \\   /  / __ \\_");
        System.out.println("|___| |____/\\____/ \\_/    \\/\\_/   \\________(____  /\\_/  (____  /");
        System.out.println("                                                \\/           \\/");
		
		float f1 = 0.4f;
        float f2 = 0.5f;
        System.out.println(Math.round(f1));
        System.out.println(Math.round(f2));
		
		int x = Integer.MAX_VALUE;
        long x2 = x+1L;
        long x3 = Integer.MIN_VALUE-1L;
        System.out.println(x);
        System.out.println(x2);
        System.out.println(x3);
		
		System.out.println(String.format("%1.2f", 12345678.123456));
		
		// 大小写字母反转
		if(args.length==0) {
            System.out.println("Please input string...");
            return;
        }
        char[] chs = args[0].toCharArray();
        for(int i=0; i<chs.length; i++) {
            if(chs[i]<=('Z'))
                chs[i] = (char)(chs[i]+32);
            else
                chs[i] = (char)(chs[i]-32);
        }
        System.out.println(new String(chs));
		
		// 判定短路与非短路测试
		if(1==2 & 1/0==0)
            System.out.println("OK1");
        if(1==2 && 1/0==0)
            System.out.println("OK2");
        if(1==1 | 1/0==0)
            System.out.println("OK3");
        if(1==1 || 1/0==0)
            System.out.println("OK4");
		
	}
	
}