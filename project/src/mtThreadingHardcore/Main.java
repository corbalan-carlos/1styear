package mtThreadingHardcore;

public class Main {
	public static void main(String[] args) {
		NumberGiver giver=new NumberGiver();
		giver.counter=new Counter();
		PrimeSearch a=new PrimeSearch(0,giver,giver.counter);
		PrimeSearch b=new PrimeSearch(1,giver,giver.counter);
		PrimeSearch c=new PrimeSearch(2,giver,giver.counter);
		a.start();
		b.start();
		c.start();
		
		
	}
	
}
