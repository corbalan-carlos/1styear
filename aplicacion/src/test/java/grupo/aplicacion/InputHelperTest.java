package grupo.aplicacion;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;

import org.junit.Before;
import org.junit.Test;

public class InputHelperTest {
	InputHelper input;
	@Before
	public void before(){
		new Config();
	}
	@Test
	public void test() {
		ByteBuffer buffer=ByteBuffer.wrap("a".getBytes());
		input=new InputHelper(new ByteArrayInputStream(buffer.array()));
		assertEquals("no ha devuelto el valor esperado",'a',input.readChar());
	}
	@Test
	public void testUnicode() {
		ByteBuffer buffer=ByteBuffer.wrap("🦞".getBytes());
		input=new InputHelper(new ByteArrayInputStream(buffer.array()));
		assertEquals("deberia devolver -2",-2,input.readChar());
	}
	@Test
	public void testGetLine() {
		ByteBuffer buffer=ByteBuffer.wrap("a\n".getBytes());
		Config.currentSystemProperties.lineDelimitator="\n";
		input=new InputHelper(new ByteArrayInputStream(buffer.array()));
		assertEquals("ha devuelto lo esperado","a",input.readLine());
	}
	@Test 
	public void testEndLine() {
		ByteBuffer buffer=ByteBuffer.wrap("a\r\n".getBytes());
		Config.currentSystemProperties.lineDelimitator="\r\n";
		input=new InputHelper(new ByteArrayInputStream(buffer.array()));
		assertEquals("no devuelve la cadena que corresponde al cambiar el final"
				+ "de linea por defecto","a",input.readLine());
	}
	@Test
	public void testUnicodeInString() {
		ByteBuffer buffer=ByteBuffer.wrap("b🦞\n".getBytes());
		input=new InputHelper(new ByteArrayInputStream(buffer.array()));
		assertEquals("debe ignorar el caracter unicode y devolver"
				+ "todo lo escrito hasta antes","b",input.readLine());
	}
	@Test
	public void endOfInput() {
		ByteBuffer buffer=ByteBuffer.wrap("abc".getBytes());
		input=new InputHelper(new ByteArrayInputStream(buffer.array()));
		assertEquals("debe devolver todo lo que se encuentra hasta "
				+ "acabar el input","abc",input.readLine());
	}
	@Test
	public void overflow() {
		ByteBuffer buffer=ByteBuffer.wrap(("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa").getBytes());
		input=new InputHelper(new ByteArrayInputStream(buffer.array()));
		assertEquals("debe devolver todo lo que se encuentra hasta "
				+ "acabar el input",null,input.readLine());
	}
	@Test
	public void testNewLineDelimitator() {
		ByteBuffer buffer=ByteBuffer.wrap("a\n".getBytes());
		input=new InputHelper(new ByteArrayInputStream(buffer.array()));
		assertEquals("no lee bien","a",input.readLine("\n"));
	}
	@Test
	public void GT3() {
		ByteBuffer buffer=ByteBuffer.wrap("a\n".getBytes());
		input=new InputHelper(new ByteArrayInputStream(buffer.array()));
		assertEquals("acepta mas de 3 caracteres para el final de las lineas",
				null,input.readLine("aaaa"));
	}
	@Test
	public void unicode() {
		ByteBuffer buffer=ByteBuffer.wrap("a\n".getBytes());
		input=new InputHelper(new ByteArrayInputStream(buffer.array()));
		assertEquals("puede utilizar caracteres unicode como delimitador"
				,null,input.readLine("🦞"));
	}
	@Test(expected = AssertionError.class)
	public void empty() {
		ByteBuffer buffer=ByteBuffer.wrap("a\n".getBytes());
		input=new InputHelper(new ByteArrayInputStream(buffer.array()));
		assertEquals("exception","a",input.readLine(""));
	}
	/*@Test
	public void test() {
		input=new InputHelper(System.in);
		assertEquals("bruh","a",input.readLine());
	}*/
}
