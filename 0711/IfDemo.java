public class IfDemo {
	public static void main(String[] args) {
		// 年龄段判断
		int age = 18;
        if(age>=0 && age<18) {
            System.out.println("青少年");
        } else if (age>=18 && age<40) {
            System.out.println("成年人");
        } else if (age>=40 && age<70) {
            System.out.println("老年人");
        } else {
            System.out.println("千年老妖");
        }
		
		// 判断是否为瑞年
		int year = 1900;
		System.out.println(year%400==0);
		System.out.println(year%4==0);
		System.out.println(year%100!=0);
		if(year%400 == 0 || year%4==0 && year%100!=0) {
			System.out.println("瑞年");
		} else {
			System.out.println("非瑞年");
		}
		
		
		
	}
}