package wait_notify;

public class Producer extends Thread
{

	Product p ;
	
	public Producer(Product p) {
		this.p = p;
		this.start();
	}
	
	@Override
	public void run() {
		int x = 1;
		
		while(true)
		{
			p.doProduction(x++);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	
		
	}

	
}
