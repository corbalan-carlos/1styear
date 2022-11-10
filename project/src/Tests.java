import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;
public class Tests {

	public static void main(String[] args) {
		String s="AAJF";
		String b="";
		int buffer;
		for (char a:s.toCharArray()) {
			b+=Integer.toString(((int) a)-0x40);
		}
		System.out.print(b);
    }
	
}