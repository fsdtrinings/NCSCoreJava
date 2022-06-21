package p1;

class Addition
{
	public void doAdd(String username,int a,int b)
	{
		//System.out.println(this);
		
		System.out.println(" User "+username+"using calculator");
		System.out.println(" some security code ..");
		
		synchronized (this) {
			
			int sum = a+b;
			try {
				
				System.out.println("\n\nsum of "+a);
				Thread.sleep(100);
				System.out.print("& "+b);
				Thread.sleep(50);
				System.out.print(" is = "+sum);
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			
			
		}//end of syn block 
		
		
	}
	
	
}

class AdditionThread extends Thread
{
	int a;
	int b;
	Addition calculator;
	String username;
	
	public AdditionThread(String username,int a, int b,Addition calculator) {
		super();
		this.a = a;
		this.b = b;
		this.calculator = calculator;
		this.username = username;
	}
	@Override
	public void run() {
		
		calculator.doAdd(username,a, b);
	}
	
	
}

public class Task1 {
	public static void main(String[] args) {
		
		Addition calculator = new Addition();
		
		AdditionThread t1 = new AdditionThread("Mike",10, 20,calculator);
		AdditionThread t2 = new AdditionThread("Jenny",100, 200,calculator);
		
		t1.start();
		t2.start();
		
		
	}

}
