package supuesto4;
import java.util.Iterator;
public class StringStruct implements Iterable<StringStruct.Triplet[]> {
	public Triplet[] get(char a) {
		a=Character.toUpperCase(a);
		return arr[a-65];
	}
	public Iterator<Triplet[]> iterator() {
		return new Iterator<Triplet[]>() {
			public boolean hasNext() {
				if (counter==25) return false;
				return true;
			}
			public Triplet[] next() {
				return arr[counter++];
			}
		};
	}
	
	public class Triplet implements Iterable {
		private int counter;
		public Iterator<Object> iterator() {
			return new Iterator<Object>() {
				public boolean hasNext() {
					if (counter==25) return false;
					return true;
				}
				public Triplet[] next() {
					return arr[counter++];
				}
			};
		}
		Triplet () {
			
		}
		
	}
	private int counter;
	Triplet arr[][];
	StringStruct() {
		this.arr=new Triplet[26][10];
		this.counter=0;
	}
}
