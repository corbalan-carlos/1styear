package grupo.aplicacion;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;

public class InputHelper {
	final InputStream input;
	InputHelper(InputStream input) {
		this.input=input;
	}
	int readChar() {
		int i;
		ByteBuffer buff=ByteBuffer.allocate(4);
		try {
			if ((i=input.read())==-1) {
				return -1;
			}
		} catch (IOException e) {
			return -3;
		}
		buff.put((byte)i);
		int c=0;
		if((buff.get(0)&0b11110000)==0b11110000) {
			c=3;
		} else if((buff.get(0)&0b11100000)==0b11100000) {
			c=2;
		} else if ((buff.get(0)&0b11000000)==0b11000000) {
			c=1;
		} else { 
			buff.order(ByteOrder.LITTLE_ENDIAN);
			return buff.get(0);
		}
		for (int j=0;j<c;j++) {	
			try {
				if ((i=input.read())==-1) {
					if (buff.position()==1) {
						buff.put((byte)0b0);
						break;
					}
					return i;
				}
			} catch (IOException e) {
				return -3;
			}
			
			buff.put((byte)i);
		}
		buff.order(ByteOrder.LITTLE_ENDIAN);
		char a=Config.currentSystemProperties.encoding.decode(buff.clear()).charAt(0);
		if (Character.isSurrogate(a)) {
				return -2;
		}
		return buff.getChar(0);
	}
	String readLine() {
		StringBuilder str=new StringBuilder(64);
		int i;
		CharBuffer buff=CharBuffer.wrap(Config.currentSystemProperties.lineDelimitator.toCharArray());
		int c=0;
		while ((i=readChar())>0) {
			if (i==buff.get(c)) {
				c++;
			}
			str.append((char) i);
			if (buff.capacity()==c) break;
			if (str.length()==str.capacity()) return null;
		}
		str.delete(str.length()-c, str.length());
		return str.toString();
	}
	String readLine(String lineDelimitator) {
		if (lineDelimitator.length()>3||lineDelimitator.isEmpty()) return null;
		if (lineDelimitator.length()!=lineDelimitator.getBytes().length) return null;
		StringBuilder str=new StringBuilder(64);
		int i;
		CharBuffer buff=CharBuffer.wrap(lineDelimitator.toCharArray());
		int c=0;
		while ((i=readChar())>0) {
			if (i==buff.get(c)) {
				c++;
			}
			str.append((char) i);
			if (buff.capacity()==c) break;
			if (str.length()==str.capacity()) return null;
		}
		str.delete(str.length()-c, str.length());
		return str.toString();
	}
}
