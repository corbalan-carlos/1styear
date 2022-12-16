package lc;
import java.util.ArrayList;
public class SumOfSubArrayMinimuns {
	public static void main(String[] args) {
		int[] array= {
			51,94,11,56

		};
		System.out.print(new SumOfSubArrayMinimuns().sumSubarrayMins(array));

	}
	public int sumSubarrayMins(int[] arr) {
		if (arr.length==1) return arr[0];
		final long mod = 1000000007;
		long sum=0;
		int [] stack=new int[arr.length];
		int [] stack2=new int[arr.length];
		int [] stack3=new int[arr.length];
		int min=Integer.MAX_VALUE;
		for (int l=0,j=-1,k=-1;l<arr.length;) {
			for (int i=0;i<arr.length-l;i++) {	
				if (arr[i]<min) {
					stack[++j]=arr[i];
					stack3[j]=j-i+1;
					min=arr[i];
				} else {
					stack[j]+=min;
					stack2[++k]=arr[i];
				}
			}
			//System.out.print(j+"\n");
			k=-1;
			l=j+1;
			min=Integer.MAX_VALUE;
			arr=stack2.clone();
		}
		for (int i=0;i<arr.length;i++) sum+=stack[i]*stack3[i];
		for (int i:stack) System.out.print(i+"\n");
		System.out.print("\n");
	    return (int) (sum%mod);
	}
	
}
