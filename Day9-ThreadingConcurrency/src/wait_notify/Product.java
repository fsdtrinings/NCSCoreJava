package wait_notify;

public class Product {
	
	private int productId;
	boolean isReady = false;
	
	
	
	public synchronized void doProduction(int id)
	{
		while(isReady == true )
		{
			try {
				wait();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
		// --- code to produce product 
		this.productId = id;
		System.out.println("Product "+productId+" is ready");
		
		
		this.isReady = true;
		
		// --- and notify 
		notify();
		
		
	}//end production()
	
	
	public synchronized void doConsumption()
	{
		
		while(isReady == false)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
		// ---- code to consume the product 
		System.out.println("Product "+productId+" is Consumed");
		this.isReady = false;
		// --- notify
		notify();
	}
	
	

}
