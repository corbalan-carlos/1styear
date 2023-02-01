package grupo.aplicacion;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class SessionTest {
	File a;
	@Rule 
	public final TemporaryFolder folder = new TemporaryFolder();
	@Before
	public void a() {
		new Config();
		try {
			this.a= folder.newFile();
			Config.userFile=a.getCanonicalPath();
			FileWriter aW=new FileWriter(a);
			aW.append("user:password:name:nif:email:address:birthdate:role\n");
			aW.close();
		} catch (IOException e) {
			
		}
	}
	/*@Test
	public void testCorrectLogin() {
		ByteBuffer buff=Config.currentSystemProperties.encoding.encode("validuser");
		simulatedInput=new ByteArrayInputStream(buff.array());
		System.setIn(simulatedInput);
		try {
			assertTrue("el login ha fallado",session.login("validuser"));
		} catch (IOException e) {
			assert false:"burh";
		}
	}
	@Test
	public void testBadLogin() {
		ByteBuffer buff=Config.currentSystemProperties.encoding.encode("unvalideUser");
		simulatedInput=new ByteArrayInputStream(buff.array());
		System.setIn(simulatedInput);
		try {
			assertFalse("el login ha funcionado",session.login("validUser"));
		} catch (IOException e) {
			assert false:"burh";
		}
	}
	@Test(expected=UnicodePanicException.class)
	public void breakReadAlphanum() {
		ByteBuffer buff=Config.currentSystemProperties.encoding.encode("🦞");
		simulatedInput=new ByteArrayInputStream(buff.array());
		System.setIn(simulatedInput);
		try {
			assertTrue("el login ha fallado",session.login("validuser"));
		} catch (IOException e) {
			assert false:"burh";
		}
	}
	@Test(expected=BufferOverflowException.class)
	public void overflowLogin() {
		ByteBuffer buff=Config.currentSystemProperties.encoding.encode("abcdefghijklmnopqrstuvwxyz");
		simulatedInput=new ByteArrayInputStream(buff.array());
		System.setIn(simulatedInput);
		try {
			assertTrue("el login ha fallado",session.login("validuser"));
		} catch (IOException e) {
			assert false:"burh";
		}
	}*/
	/*
	@Test
	public void correctLogin() {
		ByteBuffer buff=Config.currentSystemProperties.encoding.encode("user\npassword");
		ByteArrayInputStream simulatedInput=new ByteArrayInputStream(buff.array());
		Session session =new Session(simulatedInput);
		try {
			assertTrue("El login ha fallado",session.login());
		} catch (IOException e) {
			assert false;
		}
	}
	@Test
	public void wrongLogin() {
		ByteBuffer buff=Config.currentSystemProperties.encoding.encode("unvaliduser\npassword");
		ByteArrayInputStream simulatedInput=new ByteArrayInputStream(buff.array());
		Session session =new Session(simulatedInput);
		try {
			assertFalse("El login ha funcionado",session.login());
		} catch (IOException e) {
			assert false;
		}
	}
	@Test
	public void nonexistantLogin() {
		ByteBuffer buff=Config.currentSystemProperties.encoding.encode("carlos");
		ByteArrayInputStream simulatedInput=new ByteArrayInputStream(buff.array());
		Session session =new Session(simulatedInput);
		try {
			assertFalse("El login ha funcionado",session.login());
		} catch (Exception e) {
			assert false:"burh";
		}
	}*/
	@Test
	public void newUser() {
		Session session=new Session(System.in);
		assertTrue("bruh",session.signup());
		boolean a=true;
		while(a);
	}
	@Test
	public void wrongSignUp() {
		Session session=new Session(System.in);
		assertFalse("bruh",session.signup());
	}
}
