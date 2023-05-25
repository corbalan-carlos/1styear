package Classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class Maze {
	private char[][]map;
	private String filename;
	private boolean loaded;
	private int startI;
	private int startJ;
	private int endI;
	private int endJ;
	Scanner fileS;
	public Maze() {
		this.loaded=false;
	}
	public boolean loadMaze() { 
		System.out.print("Seleccione el laberinto a cargar\n");
		this.filename=Interface.getString();
		File file=new File(Config.MAZE_PATH+filename);
		try {
			fileS=new Scanner(file);
			
		} catch (FileNotFoundException e) {
			System.out.print("Laberinto no encontrado\n");
			return false;
		}
		Vector<String> v= new Vector<String>();
		
		while (fileS.hasNext()) {
			v.add(fileS.nextLine());
		}
		this.map=new char[v.size()][v.get(0).length()];
		for (int i=0;i<map.length;i++) {
			for (int j=0;j<map[0].length;j++) {
				map[i][j]=v.get(i).charAt(j);
			}
		}
		System.out.print("Laberinto cargado correctamente");
		this.loaded=true;
		return true;
	}
	public boolean showMap() {
		if (loaded==false) return false;
		System.out.print(" ");
		for (int i=0;i<map[0].length;i++) System.out.print(i%10);
		System.out.print("\n");
		int c1=0;
		for (char[] i: map) {
			System.out.print(c1%10);
			for (char j:i) {
				System.out.print(j);
			}
			System.out.print("\n");
			c1++;
		}
		return true;
	}
	public boolean setEntrancesExit() {
		int[] arr=new int [4];
		System.out.print("La coordenada I del principio\n");
		arr[0]=startI=Interface.getInt();
		System.out.print("La coordenada J del principio\n");
		arr[1]=startJ=Interface.getInt();
		System.out.print("La coordenada I del final\n");
		arr[2]=endI=Interface.getInt();
		System.out.print("La coordenada J del final\n");
		arr[3]=endJ=Interface.getInt();
		if (arr[0]<0|| arr[2]<0|| arr[0]>map.length|| arr[1]>map.length) {
			
					System.out.print("Numero no valido\n");
				startI=-1;
				endI=-1;
				endI=-1;
				endJ=-1;
				return false;
		}
		if (arr[1]<0|| arr[3]<0|| arr[1]>map[0].length|| arr[3]>map[0].length) {
			System.out.print("Numero no valido\n");
			startI=-1;
			endI=-1;
			endI=-1;
			endJ=-1;
			return false;
		}
		if (map[arr[0]][arr[1]]=='#') {
			System.out.print("Casilla de entrada no valida\n");
			startI=-1;
			endI=-1;
			endI=-1;
			endJ=-1;
			return false;
		}
		if (map[arr[2]][arr[3]]=='#') {
			System.out.print("Casilla de salida no valida\n");
			startI=-1;
			endI=-1;
			endI=-1;
			endJ=-1;
			return false;
		}
		map[arr[0]][arr[1]]='E';
		map[arr[2]][arr[3]]='S';
		return true;
	}
	
}
