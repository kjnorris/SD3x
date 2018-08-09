import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

class MazeTest {

	/*
	@Test
	void testMaze() {
		fail("Not yet implemented");
	}

	@Test
	void testSolveMaze() {
		fail("Not yet implemented");
	}
	*/

	@Test
	void testCreateGrid() {
		List<Maze.Move> escapeRoute = new LinkedList<Maze.Move>();
		escapeRoute.add(Maze.Move.LEFT);
		escapeRoute.add(Maze.Move.UP);
		escapeRoute.add(Maze.Move.UP);
		escapeRoute.add(Maze.Move.RIGHT);
		escapeRoute.add(Maze.Move.RIGHT);
		escapeRoute.add(Maze.Move.DOWN);
		escapeRoute.add(Maze.Move.RIGHT);
		escapeRoute.add(Maze.Move.RIGHT);
		escapeRoute.add(Maze.Move.UP);
		escapeRoute.add(Maze.Move.UP);
		escapeRoute.add(Maze.Move.UP);
		try {
			Maze myMaze = new Maze("mazeMedium.txt");
			// myMaze.printAdj();
			// myMaze.printStartEnd();
			assertEquals(escapeRoute, myMaze.solveMaze());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// fail("Not yet implemented");
		// assertTrue(true);

	}

}
