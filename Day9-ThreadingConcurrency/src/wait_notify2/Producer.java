package wait_notify2;

public class Producer extends Thread 
{
	
	Product p;
	
	public Producer(Product p) 
	{
		
		this.p=p;
		this.start();
	}
	
	@Override
	public void run() 
	{
		
		int count=1;
		
		while(true) 
		{
			p.make(count++);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}

}
