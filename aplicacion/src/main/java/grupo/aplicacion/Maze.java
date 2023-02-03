package grupo.aplicacion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Vector;

public class Maze {
	private char[][]map;
	private String filename;
	private boolean loaded;
	private int startI;
	private int startJ;
	private int endI;
	private int endJ;
	private InputHelper teclado;
	public Maze(InputStream in) {
		this.loaded=false;
		this.teclado=new InputHelper(in);
	}
	boolean loadMaze() { 
		System.out.print("Seleccione el laberinto a cargar\n");
		this.filename=teclado.readLine();
		InputHelper in=null;
		try {
			in=new InputHelper(new FileInputStream(Config.mazeDir+filename));
		} catch (FileNotFoundException e) {
			System.out.print("Laberinto no encontrado\n");
			return false;
		}
		String a;
		Vector<String> v= new Vector<String>();
		while ((a=in.readLine())!=null) {
			v.add(a);
		}
		this.map=new char[v.size()][v.get(0).length()];
		for (int i=0;i<map.length;i++) {
			for (int j=0;j<map[0].length;j++) {
				map[i][j]=v.get(i).charAt(j);
			}
		}
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
		arr[0]=startI=teclado.readLine().charAt(0)-48;
		System.out.print("La coordenada J del principio\n");
		arr[1]=startJ=teclado.readLine().charAt(0)-48;
		System.out.print("La coordenada I del final\n");
		arr[2]=endI=teclado.readLine().charAt(0)-48;
		System.out.print("La coordenada J del final\n");
		arr[3]=endJ=teclado.readLine().charAt(0)-48;
		for (int i:arr) {
			if (i>10||i<0) {
				System.out.print("Numero no valido\n");
				startI=-1;
				endI=-1;
				endI=-1;
				endJ=-1;
				return false;
			}
		}
		if (map[arr[0]][arr[1]]=='#') {
			System.out.print("Casilla de entrada no valida");
			startI=-1;
			endI=-1;
			endI=-1;
			endJ=-1;
			return false;
		}
		if (map[arr[2]][arr[3]]=='#') {
			System.out.print("Casilla de salida no valida");
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
