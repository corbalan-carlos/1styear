package grupo.aplicacion;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.ByteBuffer;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class SessionTest {
	Session session;
	ByteArrayInputStream simulatedInput;
	@Before
	public void a() {
		new Config();
		this.session=new Session();
		ByteBuffer buff=Config.currentSystemProperties.encoding.encode("🦞");
		simulatedInput=new ByteArrayInputStream(buff.array());
		System.setIn(simulatedInput);
	}
	@Test
	public void testCorrectLogin() {
		assertTrue("ha de funcionar",session.login("validUser"));
	}
	@Test
	public void testBadLogin() {
		assertTrue("no ha de funcionar",session.login("unvalidUser"));
	}
	@Test
	public void breakReadAlphanum() {
		assertTrue("🦞",session.login("validUser"));
	}
}
