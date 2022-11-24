package lc;
import java.util.HashMap;
import java.util.ArrayList;
public class WordSearch {
	static char[][] board={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
	public static void main(String args[]) {
		if (new WordSearch().exist(board, "bee")) System.out.print("a");;
	}
	public boolean exist(char[][] board, String word) {
		if (word.length()==0) return false;
		HashMap<Character,NodeList> ref=new HashMap<Character,NodeList>();
	    for (int i=0;i<board.length;i++) {
	    	for (int j=0;j<board[i].length;j++) {
	    		
	    		if (!ref.containsKey(board[i][j])) {
	    			ref.put(board[i][j], new NodeList(board.length,board[0].length));
	    		}
	    		Node a=(i-1>=0)?ref.get(board[i-1][j]).get(i-1,j):null;
	    		Node b=(j-1>=0)?ref.get(board[i][j-1]).get(i,j-1):null;
	    		ref.get(board[i][j]).add(new Node(
	    				board[i][j],
	    				a,
	    				b,
	    				null,
	    				null
	    			),i,j
	    		);
	    		if (a!=null && b!=null) {
	    			a.down=ref.get(board[i][j]).get();
	    			b.right=ref.get(board[i][j]).get();
	    		}
	    	}
	    }
	    for (int i=0;i<ref.get(word.charAt(0)).counter;i++) {
	    	int counter=0;
	    	Node currentNode=ref.get(word.charAt(0)).get(i);
	    	Node previousNode=null;
	    	while (true) {
	    		try {
	    			word.charAt(counter);
	    		} catch (IndexOutOfBoundsException E) {
	    			return true;
	    		}
	    		if (currentNode.down!=null && !currentNode.down.run && currentNode.down.value==word.charAt(counter)) {
	    			previousNode=currentNode;
	    			currentNode=currentNode.down;
	    			counter++;
	    		} else if (currentNode.up!=null && !currentNode.up.run && currentNode.up.value==word.charAt(counter)) {
	    			previousNode=currentNode;
	    			currentNode=currentNode.up;
	    			counter++;
	    		} else if (currentNode.left!=null && !currentNode.left.run && currentNode.left.value==word.charAt(counter)) {
	    			previousNode=currentNode;
	    			currentNode=currentNode.left;
	    			counter++;
	    		} else if (currentNode.right!=null && !currentNode.right.run && currentNode.right.value==word.charAt(counter)) {
	    			previousNode=currentNode;
	    			currentNode=currentNode.right;
	    			counter++;
	    		} else {
	    			currentNode=previousNode;
	    		}
	    	}
		}
		return false;
	}
	class NodeList extends ArrayList<Node >{
		private static final long serialVersionUID = -8395463931564857586L;
		int counter;
		int[][] arr;
		ArrayList<Node> list;
		public boolean add(Node s, int a, int b) {
			if (list.add(s)) {
				arr[a][b]=counter++;
				return true;
			}
			return false;
		}
		
		public Node get() {
			if (list.get(counter-1).getClass()==Node.class) return list.get(counter-1);
			return null;
		}
		@Override
		public Node get(int a) {
			if (list.get(a).getClass()==Node.class) return list.get(a);
			return null;
		}
		public Node get(int a,int b) {
			int c=arr[a][b];
			if (list.get(c).getClass()==Node.class) return list.get(c);
			return null;
		}
		NodeList(int a, int b) {
			this.counter=0;
			this.arr=new int[a][b];
			list=new ArrayList<Node>();
		}
		
	}
	class Node {
		char value;
		boolean run;
		Node up;
		Node down;
		Node left;
		Node right;
		
		Node(char value,Node up,Node down, Node left, Node right) {
			this.value=value;
			this.run=false;
			this.up=up;
			this.down=down;
			this.left=left;
			this.right=right;
		}
	}
}
