import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GraphTest {


	@Test
	void testNumShortestPaths() {
		Graph myG = new Graph(6);
		myG.addEdge(0, 1);
		myG.addEdge(0, 2);
		myG.addEdge(0, 3);
		myG.addEdge(1, 5);
		myG.addEdge(2, 5);
		myG.addEdge(2, 4);
		myG.addEdge(3, 4);
		myG.addEdge(4, 5);
		int numPaths = myG.numShortestPaths(0, 5);
		System.out.println(numPaths);
		assertEquals(2, numPaths);
		// fail("Not yet implemented");
	}

	
	@Test
	void testNumShortestPaths2() {
		Graph myG = new Graph(9);
		myG.addEdge(0, 1);
		myG.addEdge(0, 2);
		myG.addEdge(1, 4);
		myG.addEdge(1, 3);
		myG.addEdge(2, 3);
		myG.addEdge(2, 5);
		myG.addEdge(3, 5);
		myG.addEdge(4, 6);
		myG.addEdge(3, 6);
		myG.addEdge(3, 7);
		myG.addEdge(5, 7);
		myG.addEdge(6, 8);
		myG.addEdge(7, 8);
		
		int numPaths = myG.numShortestPaths(0, 8);
		System.out.println(numPaths);
		assertEquals(6, numPaths);
		// fail("Not yet implemented");
	}

}
