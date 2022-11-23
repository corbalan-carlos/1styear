package lc;

public class ValidSudoku {
	static char[][] input= {
					{'5','3','.','.','7','.','4','.','.'},
					{'6','.','.','1','9','5','.','.','.'},
					{'.','9','8','.','.','.','.','6','.'}
					,{'8','.','.','.','6','.','.','.','3'}
					,{'4','.','.','8','.','3','.','.','1'}
					,{'7','.','.','.','2','.','.','.','6'}
					,{'.','6','.','.','.','.','2','8','.'}
					,{'.','.','.','4','1','9','.','.','5'}
					,{'.','.','.','.','8','.','.','7','9'}
	};
	public static void main(String[] args) {
		if(new ValidSudoku().isValidSudoku(input)) System.out.print("a");
		
	}
	boolean isValidSudoku(char[][] board) {
		char[] auxArr=new char[9];
		for (int i=0;i<9;i++) {
			if (!isValidArray(board[i])) return false;
			for (int j=0;j<9;j++) {
				auxArr[j]=board[j][i];
			}
			if (!isValidArray(auxArr)) return false;
			
		}
		int counter=0;
		for (int i=0;i<9;i+=3) {
			for (int j=0;j<9;j+=3) {
				counter=0;
				for (int k=i;k<i+3;k++) {
					for (int l=j;l<j+3;l++) {
						auxArr[counter++]=board[k][l];
					}
				}
				if (!isValidArray(auxArr)) return false;
			}
		}
		return true;
	}
	boolean isValidArray(char[] input) {
		boolean[] auxArr=new boolean[9];
		for (char i:input) {
			if (i=='.') continue;
			if(auxArr[Integer.parseInt(i+"")-1]) {
				return false;
			} else {
				auxArr[Integer.parseInt(i+"")-1]=true;
			}
		}
		return true;
	}

}
