package p1;

class MyThread extends Thread
{
	@Override
	public void run() {
		for(int i = 0;i<10;i++)
		{
			System.out.println("MyThread :- "+i);
			
		}
	}
}



public class Demo1 {
	
	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		
		/*
		MyThread2 runnableObj = new MyThread2();
		Thread t2 = new Thread(runnableObj);
		
		
		t2.start();
		*/
		
		
		for(int i = 0;i<10;i++)
		{
			System.out.println("Main :- "+i);
			
			if(i == 5)
			{
				t1.start();
				try {
					t1.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
		
	}

}
























