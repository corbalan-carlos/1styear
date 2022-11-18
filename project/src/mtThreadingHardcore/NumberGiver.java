package mtThreadingHardcore;

public class NumberGiver {
	private static int i=3;
	public Counter counter;
	synchronized public boolean giveNumber (PrimeSearch caller){
		if (NumberGiver.i>98) {
			return true;
		}
		caller.target=i+=2;
		return false;
	}

}
