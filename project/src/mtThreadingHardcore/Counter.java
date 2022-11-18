package mtThreadingHardcore;

public class Counter extends Thread{
	static public int counter=0;
	
	
	@Override
	public void run() {
		synchronized (this) {
			try {
				this.wait();
			} catch (Exception E ) {
				System.out.print(E.getMessage());
			}
		}
		System.out.print(counter+"\n");
	}
}
