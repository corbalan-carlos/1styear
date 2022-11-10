package lc;
import java.util.ArrayList;
import java.util.List;
public class FindKClosesteElements {
	 public List<Integer> findClosestElements(int[] arr, int k, int x) {
	        int n=0;
			List<Integer> list=new ArrayList<>();
			for (int i=0;i<arr.length;i++) {
				if (Math.abs(arr[i]-x)<Math.abs(arr[n]-x) ||
					(Math.abs(arr[i]-x)==Math.abs(arr[n]-x) && arr[i]<x)	) {
					n=i;
				}
			}
			int offset=n-k;
	        while (offset<0) offset++;
	//		while (offset+k>arr.length) offset--; 
			if (k==1) {
				list.add(arr[n]);
				for (Integer integer:list) {
					System.out.print(integer+",");
				}
				return list;
			} else if (k==arr.length) {
				for (int i=0;i<arr.length;i++) {
					list.add(arr[i]);
				}
				for (Integer integer:list) {
					System.out.print(integer+",");
				}
				return list;
			}
			//System.out.print(arr[n]+"\n");
			//int pointer=0;
			
			System.out.print(offset+"\n");
			while (true ){
				if ((Math.abs(arr[offset]-x)<Math.abs(arr[offset+k]-x) || (Math.abs(arr[offset]-x)==Math.abs(arr[offset+k]-x)) && arr[offset]<arr[offset+k])) {
					break;
				} else if (k+offset+1==arr.length){
					offset++;
					break;
	            } else {
					offset++;
				}
			}
			//System.out.print(offset+"\n");
			for (int i=offset;i<offset+k;i++) {
				list.add(arr[i]);
			}
			for (Integer integer:list) {
				System.out.print(integer+",");
			}
	        return list;
		}
}
