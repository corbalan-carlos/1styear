package mtThreadingHardcore;
public class PrimeSearch extends Thread {
	int target;
	int n;
	Counter counter;
	private NumberGiver giver;
	@Override
	public synchronized void run() {
		System.out.print(Thread.currentThread().getName()+" "+n+" "+"\n");
		giver.giveNumber(this);
		while (true) {
			for (int j=3;j<=target;j+=2) {
				if (target/j==1&&target%j==0) {
					System.out.print(n+":"+target+"\n");
					Counter.counter++;
					break;
				}
				if (target%j==0) break;
			}
			if (giver.giveNumber(this)) {
				break;
			}
		}
		synchronized (this) {
			try {
				this.wait();
			} catch (Exception E ) {
				System.out.print(E.getMessage());
			}
		}
	}
	PrimeSearch(int n, NumberGiver numberGiver,Counter counter) {
		this.n=n;
		this.giver=numberGiver;
		this.counter=counter;
	}
	
}
