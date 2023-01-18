package Practica4;

public class Ejercicio7 {
	int buscarInt(int[] arr, int a) {
		for (int i=0;i<arr.length-1;i++) {
			if (arr[i]==a) return i;
		}
	}
}
