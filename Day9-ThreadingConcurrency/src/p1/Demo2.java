package p1;

class MyThread2 implements Runnable
{
	@Override
	public void run() {
		for(int i = 0;i<10;i++)
		{
			System.out.println("Runnable Thread :- "+i);
		}
	}
	
}

public class Demo2 {
	
	public static void main(String[] args) {
		
		
	
		MyThread2 runnableObj = new MyThread2();
		Thread t2 = new Thread(runnableObj);
		
		
		t2.start();
		
		
		
		for(int i = 0;i<10;i++)
		{
			System.out.println("Main :- "+i);
			if(i == 5)
			{
				Thread.yield(); // or .join()
			}
			
		}
		
		
		
		
	}

}




























