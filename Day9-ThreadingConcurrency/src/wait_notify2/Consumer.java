package wait_notify2;

public class Consumer extends Thread {
	
	Product p;
	
	public Consumer(Product p){
		this.p=p;
		this.start();
	}
	
	@Override
	public void run() {
		while(true) {
			p.buy();
			System.out.println("--------------------------------------------");
			try {
				Thread.sleep(500);
			} 
			catch (Exception e) {
				
				
			}
			
		}
		
	}
		
		
	

}
