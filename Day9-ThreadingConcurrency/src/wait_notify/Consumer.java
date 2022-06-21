package wait_notify;

public class Consumer extends Thread
{
	Product p ;
	
	public Consumer(Product p) {
		this.p = p;
		this.start();
	}
	
	@Override
	public void run() {
		while(true)
		{
			p.doConsumption();
			System.out.println("--------------------------------------------");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
	}

	
}