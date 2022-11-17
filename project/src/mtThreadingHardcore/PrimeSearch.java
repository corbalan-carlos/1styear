package mtThreadingHardcore;
import java.time.*;
public class PrimeSearch extends Thread {
	int target;
	boolean result;
	@Override
	public synchronized void run() {
		/*for (int j=3;j<=target;j+=2) {
			if (target/j==1&&target%j==0) {
				result=true;
				break;
			}
			if (target%j==0) break;
		}*/
		
		try {
			Thread.sleep(5000);
			System.out.print(LocalDateTime.now()+"\n");
			this.wait();
		} catch (Exception E) {
			
		}
		
		System.out.print("Waking Up\n");
	}
	
}
