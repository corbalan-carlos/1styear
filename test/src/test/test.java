package test;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
public class test {

	public static void main(String[] args) {
		int arr[]= {1,2};
		int k=1;
		int x=2;
		List<Integer> list=new ArrayList<>();
		int minPointer=0;
		int maxPointer=k;
		for (int i=0;i<arr.length;i++) {
			if (Math.abs(arr[minPointer]-x)<Math.abs(arr[maxPointer]-x) 
				|| (Math.abs(arr[minPointer]-x)<Math.abs(arr[maxPointer]-x) && arr[minPointer]<arr[maxPointer])) {
				minPointer++;
				maxPointer++;
			} else  if (Math.abs(arr[minPointer]-x)>Math.abs(arr[maxPointer]-x) 
				|| (Math.abs(arr[minPointer]-x)>Math.abs(arr[maxPointer]-x) && arr[minPointer]>arr[maxPointer])) {
				minPointer--;
				maxPointer--;
			}
				
		}
		for (int i=minPointer;i<maxPointer;i++) list.add(arr[i]);
		for( Integer n:list) {
			System.out.print(n+"\n");
		}
	}

}
