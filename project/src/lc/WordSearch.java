package lc;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.function.Consumer;
public class WordSearch {
	static char[][] board={{'a','b','c','e'},{'s','f','c','s'},{'a','d','e','e'}};
	public static void main(String args[]) {
		if (new WordSearch().exist(board, "abcced")) System.out.print("a");;
	}
	    public boolean exist(char[][] board, String word) {
			if (word.length()==0) return false;
			HashMap<Character,NodeList> ref=new HashMap<Character,NodeList>();
		    for (int i=0;i<board.length;i++) {
		    	for (int j=0;j<board[i].length;j++) {
		    		boolean cFlag=true;
		
		    		for (int k=0;k<word.length();k++) {
		    			if (word.charAt(k)==board[i][j]) {
		    				cFlag=false;
		    			}
		    		}
		    		if (cFlag) continue;
		    		if (!ref.containsKey(board[i][j])) {
		    			ref.put(board[i][j], new NodeList(board.length,board[0].length));
		    		}
		    		Node a=null;
		    		try {
		    			if (ref.get(board[i-1][j]).get(i-1,j)!=null) {
		    				a=ref.get(board[i-1][j]).get(i-1,j);
		    			}
		    		} catch (Exception ArrayIndexOutOfBoundsException) {};
		    		Node b=null;
		    		try {
		    			if (ref.get(board[i][j-1]).get(i,j-1)!=null && (j-1>=0)) {
		    				b=ref.get(board[i][j-1]).get(i,j-1);
		    			} 
		    		} catch (Exception ArrayIndexOutOfBoundsException) {};
		    		ref.get(board[i][j]).add(new Node(
		    				board[i][j],
		    				a,
		    				null,
		    			    b,
		    				null
		    			),i,j
		    		);
		    		if (a!=null) {
		    			a.down=ref.get(board[i][j]).get();
		    		}
		    		if (b!=null) {
		    			b.right=ref.get(board[i][j]).get();
		    		}
		    	}
		    }
	        if (board.length*board[0].length<word.length()|| ref.size()!=uniqueString(word).length()) return false;
		    for (int i=0;i<ref.get(word.charAt(0)).counter;i++) {
		    	System.out.print(ref.get(word.charAt(0)).get(i).value+"\n");
		    	if (recursiveDepthSearch(ref.get(word.charAt(0)).get(i),"",0,word)) return true;
	            ref.get(word.charAt(0)).get(i).run=false;
		    }
		    return false;
		}
	    String uniqueString(String a) {
			HashMap<Character,Boolean> b=new HashMap<Character,Boolean>();
			String c="";
			for (int i=0;i<a.length();i++) {
				if (!b.containsKey(a.charAt(i))) {
					c+=a.charAt(i);
					b.put(a.charAt(i), true);
				}
			}
			return c;
		}
		boolean recursiveDepthSearch(Node node, String acc, int counter, String comp) {
			//System.out.print(comp.substring(0,1).concat(acc)+"\n");
	        node.run=true;
			counter++;
			if (comp.equals(comp.substring(0,1).concat(acc))) return true;
			if (node.up!=null) {
				if (node.up.value==comp.charAt(counter)&&!node.up.run) {
				//	System.out.print("up\n");
					if (recursiveDepthSearch(node.up,acc+node.up.value,counter,comp)) return true;
	                node.up.run=false;
				}
			}
			
			if (node.left!=null) {
				if (node.left.value==comp.charAt(counter)&&!node.left.run) {
				//	System.out.print("left\n");
				//	node.left.run=true;
					if (recursiveDepthSearch(node.left,acc+node.left.value,counter,comp)) return true;
	                node.left.run=false;
				}
			}
	        if (node.down!=null) {	
				if (node.down.value==comp.charAt(counter)&&!node.down.run) {
				//	System.out.print("down\n");
			//		node.down.run=true;
					if (recursiveDepthSearch(node.down,acc+node.down.value,counter,comp)) return true;
	                node.down.run=false;
				}
			}
			if (node.right!=null) {
				if (node.right.value==comp.charAt(counter)&&!node.right.run) {
				//	node.right.run=true;
				//	System.out.print("right\n");
					
					if (recursiveDepthSearch(node.right,acc+node.right.value,counter,comp)) return true;
	                node.right.run=false;
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
			public void run(Consumer<Node> a) {
				list.forEach(a);
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