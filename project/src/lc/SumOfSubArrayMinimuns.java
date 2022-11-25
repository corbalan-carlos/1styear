package lc;
import java.util.ArrayList;
public class SumOfSubArrayMinimuns {
	public static void main(String[] args) {
		int[] array= {
				256,17,5,2,0,255
		};
		new  SumOfSubArrayMinimuns().sumSubarrayMins(array);

	}
	public int sumSubarrayMins(int[] arr) {
		ArrayList<Integer> list=new ArrayList<Integer>(arr.length); 
		for (int i:arr) {
			list.add(i);
		}
		list.sort((Integer x, Integer y)-> {
			if (x>y) return ;
			return y;
		});
		for (int i:list) {
			System.out.println(i);
		}
	    return 0;
	}
}
