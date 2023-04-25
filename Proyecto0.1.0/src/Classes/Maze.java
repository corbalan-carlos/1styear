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
	public void solve() {
		MazeSolver a=new MazeSolver();
		if (a.solve()) {
			a.printSolvedMaze();
			return;
		}
		System.out.print("No se ha podido encontrar una solucion al laberinto\n");
	}
	private class MazeSolver {
		class Cell {
			int i;
			int j;
			char d;
			Cell(int i, int j) {
				this.i=i;
				this.j=j;
			}
		}
		private boolean[][] runMap;
		MazeSolver() {
			this.runMap= new boolean[map.length][map[0].length];
			this.stack=new Stack<>();
		}
		private Stack<Cell> stack;
		boolean solve() {
			stack.clear();
			Cell start=new Cell(startI,startJ);
			Cell currentCell=start;
			runMap[startI][startJ]=true;
			while (true) {
				if (currentCell.i==endI&&currentCell.j==endJ) {
					return  true;
				}
				if (currentCell.i+1<map.length) {
					if (map[currentCell.i+1][currentCell.j]!='#'
							&& !runMap[currentCell.i+1][currentCell.j]) {
						currentCell.d='v';
						stack.push(currentCell);
						runMap[currentCell.i+1][currentCell.j]=true;
						currentCell=new Cell(currentCell.i+1,currentCell.j);
						continue;
					}
				}
				if (currentCell.j+1<map[0].length) {
					if (map[currentCell.i][currentCell.j+1]!='#'
							&&!runMap[currentCell.i][currentCell.j+1]) {
						currentCell.d='>';
						runMap[currentCell.i][currentCell.j+1]=true;
						stack.push(currentCell);
						currentCell=new Cell(currentCell.i,currentCell.j+1);
						continue;
					}
				}
				if (currentCell.i-1>=0) {
					if (map[currentCell.i-1][currentCell.j]!='#'
							&&!runMap[currentCell.i-1][currentCell.j]) {
						currentCell.d='Ʌ';
						runMap[currentCell.i-1][currentCell.j]=true;
						stack.push(currentCell);
						currentCell=new Cell(currentCell.i-1,currentCell.j);
						continue;
					}
				}
				if (currentCell.j-1>=0) {
					if (map[currentCell.i][currentCell.j-1]!='#'
							&&!runMap[currentCell.i][currentCell.j-1]) {
						currentCell.d='<';
						stack.push(currentCell);
						runMap[currentCell.i][currentCell.j-1]=true;
						currentCell=new Cell(currentCell.i,currentCell.j-1);
						continue;
					}
				}
				if (stack.size()==0) {
					return false;
				}
				currentCell=stack.pop();
			}
		}
		void printSolvedMaze() {
			char[][] tempMap=map.clone();
			for (Cell a:stack) {
				tempMap[a.i][a.j]=a.d;
			}
			tempMap[startI][startJ]='E';
			for (char[] c:tempMap) {
				for (char d:c) {
					System.out.print(d);
				}
				System.out.print("\n");
			}
			
		}
		
	}
}
