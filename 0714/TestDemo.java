class Base
{
	private String name="base";

	public Base(){
	
		tallName();
        printName();
	}

	public void tallName(){
	
		System.out.println("BtallName="+name);
	}

	public void printName(){
		
	   System.out.println("BprintName="+name);
    }
}


class Sbase extends Base
{
    private String name = "Sbase";
	public Sbase(){
	
		tallName();
		printName();
	}

	public void tallName(){
	
		System.out.println("StallName="+name);
	}

	public void printName(){
		
	   System.out.println("SprintName="+name);
	}
}

public class TestDemo
{

	public static void main(String[]args){
	
		
		 Sbase s=new Sbase();
	}
}
