package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class test {
	public static void main(String args[]) {
		File test=new File("src/test/Untitled 1");
		Scanner s=null;
		try {
			s=new Scanner(test);
		} catch (FileNotFoundException E) {
			assert false;
		}
		while (true) {
			System.out.print(s.nextLine()+" ");
		}
	}
}