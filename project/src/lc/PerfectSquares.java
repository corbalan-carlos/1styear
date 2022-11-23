package lc;
import java.util.HashMap;
public class PerfectSquares {
	private static HashMap<Integer,int[]> rule= new HashMap<Integer,int[]>();
	public static void main(String[] args) {
		int n=12;
		int counter=0;
		int buffer=n;
		if (Math.sqrt(buffer)==(int) Math.sqrt(buffer)) {
			System.out.print(1);
			return;
		}
		double sqrt=Math.sqrt(buffer);
		
		rule.put(1, null);
		int[] a= {1,1};
		rule.put(2,a.clone() );
		for (int i=1;i<sqrt; i++) {		
				int pow=(int) Math.pow(i, 2);
				rule.put(pow, null);
		}
		int latestSquare=0;
		for (int i=1;i<=n; i++) {		
			if (rule.containsKey(i)) {
				latestSquare=i;
				continue;
			}
			int[] array=new int[i];
			int minN=Integer.MAX_VALUE;
			for (int j=1;j<=(int)Math.sqrt(latestSquare); j++) {
				int num=i-(int) Math.pow(j,2);
				int counter2=0;
				while (true) {
					if (rule.get(num)==null) {
						break;
					} else {
						num=rule.get(num)[1];
						counter2++;	
					}
					System.out.print("i:"+i+",j:"+j+" "+counter2+"\n");
				}
				if (counter2<minN) minN=counter2;
				array[counter2]=j;
			}
			int[] arrayBuffer=new int[2];
			arrayBuffer[0]=(int) Math.pow(array[minN], 2);
			arrayBuffer[1]=i-arrayBuffer[0];
			rule.put(i,arrayBuffer.clone());
		}
		while (true) {
			counter++;
			if (rule.get(buffer)==null) {
				break;
			} else {
				buffer=rule.get(buffer)[1];
			}
		}
		rule.forEach((Integer i, int[] j)-> {
			if (j!=null) {
				System.out.print(i+"->"+j[0]+","+j[1]+"\n");
			} else {
				System.out.print(i+"->"+"null\n");
			}
		});
		System.out.print(counter);
	}

}
