package Practica4;

public class Ejercicio6 {
	int contarIntConsecutivos(int arr[]) {
		if (arr.length==1) return 0;
		int counter=0;
		for (int i=1;i<arr.length-1;i++) {
			if (arr[i]-arr[i-1]==1) {
				counter++;
			}	else {
				counter=0;
			}
		}
		return counter;
	}
}
