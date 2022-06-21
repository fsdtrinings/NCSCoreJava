package wait_notify;

public class MainClass {
	public static void main(String[] args) {
		
		Product p = new Product();
		
		
		Producer producerThread = new Producer(p);
		Consumer consumerThread = new Consumer(p);
		
		
		
	}

}
