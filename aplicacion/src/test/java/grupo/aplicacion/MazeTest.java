package grupo.aplicacion;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;

import org.junit.Before;
import org.junit.Test;

public class MazeTest {
	@Before
	public void a() {
		new Config();
		
	}
	@Test
	public void test() {
		ByteBuffer buffer=ByteBuffer.wrap("laberinto1.txt\n1188".getBytes());
		System.setIn(new ByteArrayInputStream(buffer.array()));
		Maze maze=new Maze(System.in);
		maze.loadMaze();
		assertTrue("no ha cargado bien el laberinto",maze.setEntrancesExit());
	}
	@Test
	public void testUnexistant() {
		ByteBuffer buffer=ByteBuffer.wrap("laberinto1.txt\n1172".getBytes());
		System.setIn(new ByteArrayInputStream(buffer.array()));
		Maze maze=new Maze(System.in);
		maze.loadMaze();
		assertFalse("?",maze.setEntrancesExit());
	}
}
