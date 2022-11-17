package mtThreadingHardcore;

public class Main {
	
	public static void main(String[] args) {
		PrimeSearch a=new PrimeSearch();
		a.start();
		try {
			Thread.sleep(6000);
		} catch (Exception E) {
			
		}
		synchronized (a) {
			a.notify();
		}
		
	}

}
