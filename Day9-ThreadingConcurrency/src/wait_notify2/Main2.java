package wait_notify2;

public class Main2 {
	public static void main(String[] args) {
		
		Product k=new Product();
		
		Producer producerThread1=new Producer(k);
		Consumer consumerThread2 = new Consumer(k);
	}
	

}
