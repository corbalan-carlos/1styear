

public class a {
	/*
	 * arr es el array que se pasa
	 * 
	 * a es el principio del array
	 * 
	 * b es el final del array
	 */
	static public void main(String[] args) {
		int arr[]= {10,23,45,12,1,34,34,26,1,7,21};
		mergeSort(arr, 0, arr.length-1);
		return;
	}
	static void mergeSort(int arr[],int a,int b) {
		//int reminder=(b-a+1)%2;
		int length=(b-a+1);
		if (a+1==b|| a==b|| b-1==a) {
			int buffer;
			if (arr[b]<arr[a]) {
				buffer=arr[a];
				arr[a]=arr[b];
				arr[b]=buffer;
			}
			return; 
		} else {
			mergeSort(arr,a,a+length/2-1);
			mergeSort(arr,a+length/2,a+length-1);
		}
		int buffer;
		for (int i=a;i<b+1;i++) {
			for (int j=i;j<b+1;j++) {
				if (arr[j]<arr[i]) {
					buffer=arr[i];
					arr[i]=arr[j];
					arr[j]=buffer;
				}
			}
		}
		
	}
}
