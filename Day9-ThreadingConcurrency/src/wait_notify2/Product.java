package wait_notify2;

public class Product {
	
	private int iD;
	boolean available=false;
	
	public synchronized void make(int id) {
		
		while(available==true) {
			try {
				wait();
			}
			
			catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		this.iD=id;
		available=true;
		System.out.println("Stuff: "+iD+" Available");
		
		notify();
		
	}
	
	
public synchronized void buy() {
		
		while(available==false) {
			try {
				wait();
			}
			
			catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		available=false;
		System.out.println("Stuff: "+iD+" Ordered");
		
		notify();
		
	}

}//main class
