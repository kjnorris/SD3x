
import java.io.*;
import java.util.*;

public class Maze {
	
	Graph g; //We will store the maze internally as a graph
	int startVertex; //one of the vertices in the graph will be the start of the maze
	int endVertex; //another will be the end of the maze
	
	/**
	 * We will store an nxn maze in a textfile, and read it in.
	 * 
	 * A maze is simply represented as a textfile with 4 numbers: 0, 1, 2, 3
	 * 
	 * 0s represent walls- this is not a valid part of the maze
	 * 1s represent valid parts of the maze (i.e. blocks you can move to
	 * 2 represents the starting point of the maze
	 * 3 represents the end point of the maze.
	 * 
	 * Our constructor will create the 2d array of integers from the file for you
	 * 
	 */
	public Maze(String filename) throws IOException{
		
		//create the 2d grid from the maze textfile
		int[][] grid = createGrid(filename);
		
		//identify start and end vertices
		int n = grid.length;
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				if (grid[row][col] == 2) {
					startVertex = row*n + col;
				}
				if (grid[row][col] == 3) {
					endVertex = row*n + col;
				}
			}
		}
		
		//TODO
		//determine how to represent the graph and create it
		//initialize startVertex and endVertex
		int numVertices = n * n;
		int currVertex = 0;
		int connVertex = 0;
		g = new Graph(numVertices);
		
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				if (grid[row][col] != 0) {
					currVertex = (row * n) + (col);
					List<Integer> currEdges = g.neighbors(currVertex);
					
					// Check UP path
					if ((row != 0) && (grid[row-1][col] != 0)) {
						connVertex = ((row -1) * n) + col;
						if (!currEdges.contains(connVertex)) {
							g.addEdge(currVertex, connVertex);
						}
					}
					
					// Check DOWN path
					if ((row != (n-1)) && (grid[row+1][col] != 0)) {
						connVertex = ((row + 1) * n) + col;
						if (!currEdges.contains(connVertex)) {
							g.addEdge(currVertex, connVertex);
						}
					}
					
					// Check LEFT path
					if ((col != 0) && (grid[row][col-1] != 0)) {
						connVertex = currVertex - 1;
						if (!currEdges.contains(connVertex)) {
							g.addEdge(currVertex, connVertex);
						}
					}
					
					// Check RIGHT path
					if ((col != (n-1)) && (grid[row][col+1] != 0)) {
						connVertex = currVertex + 1;
						if (!currEdges.contains(connVertex)) {
							g.addEdge(currVertex, connVertex);
						}
					}
				}
			}
		}
	}
	
	public void printAdj() {
		int mazeSize = g.size();
		int mazeDim = (int) Math.sqrt((double) mazeSize);
		for (int i = 0; i < mazeSize; i++) {
			int col = i % mazeDim;
			int row = (int) i / mazeDim;
			List<Integer> currAdj = g.neighbors(i);
			if (!currAdj.isEmpty()) {
				System.out.print("Row : " + row + " Col: " + col + " can move to: ");
				for (Integer elem: currAdj) {
					int elemCol = elem % mazeDim;
					int elemRow = (int) elem / mazeDim;
					System.out.print("(" + elemRow + "," + elemCol + ") ");
				}
				System.out.print("\n");
			}	
		}
	}
	
	public void printStartEnd() {
		List<Integer> startNode = getRowCol(startVertex);
		int startRow = startNode.get(0);
		int startCol = startNode.get(1);
		
		List<Integer> endNode = getRowCol(endVertex);
		int endCol = endNode.get(1);
		int endRow = endNode.get(0);
		
		System.out.println("Move from: (" + startRow + "," + startCol + ")");
		System.out.println("Move to: (" + endRow + "," + endCol + ")");
	}
	
	public List<Integer> getRowCol(int currNode) {
		List<Integer> rowCol = new LinkedList<Integer>();
		int mazeSize = g.size();
		int mazeDim = (int) Math.sqrt((double) mazeSize);
		
		int col = currNode % mazeDim;
		int row = (int) currNode / mazeDim;
		
		rowCol.add(row);
		rowCol.add(col);
		
		return rowCol;
	}
	
	/**
	 * 
	 * This algorithm should solve the maze output a list of "moves", beginning at the start vertex,
	 * that can be taken to arrive at the end vertex.  You should solve the maze on the graph,
	 * using some sort of graph traversal.
	 * 
	 * More information on figuring out what "move" to output at each step can be found in the writeup!
	 * 
	 * @param g - the graph to traverse
	 * @param startVertex - the starting vertex
	 * @param endVertex - we will stop the traversal and output the list of moves when we hit this vertex
	 * 
	 */
	public List<Move> solveMaze() {
		List<Move> escapeRoute = new LinkedList<Move>();
		Set<Integer> visitedNodes = new HashSet<Integer>();
		LinkedList<Integer> escapePath = new LinkedList<Integer>();
		
		escapePath = dfs(startVertex, visitedNodes, escapePath);
		
		System.out.println("Length of route: " + escapePath.size());
		for (int i = 1; i < escapePath.size(); i++) {
			int parent = escapePath.get(i-1);
			int currNode = escapePath.get(i);
			if (parent - currNode == 1) {
				escapeRoute.add(Move.LEFT);
			} else if (currNode - parent == 1) {
				escapeRoute.add(Move.RIGHT);
			} else if (parent - currNode > 0) {
				escapeRoute.add(Move.UP);
			} else {
				escapeRoute.add(Move.DOWN);
			}
 		}
		

		//TODO
		return escapeRoute;
	}
	
	private LinkedList<Integer> dfs(int vertex, Set<Integer> visitedNodes, LinkedList<Integer> escapePath) {
		visitedNodes.add(vertex);
		escapePath.add(vertex);

		if (vertex == this.endVertex) {
			return escapePath;
		}
		
		for (int node: g.neighbors(vertex)) {
			if (!visitedNodes.contains(node)) {
				escapePath = dfs(node, visitedNodes, escapePath);
				int discardElem = escapePath.getLast();
				if (discardElem == endVertex) {
					return escapePath;
				} else {
					escapePath.removeLastOccurrence(discardElem);
				}
			}
		}
		
		return escapePath;
	}
	
	
	/**
	 * Move is an enum type- when navigating a maze, you can either move
	 * UP, DOWN, LEFT, or RIGHT
	 */
	public enum Move {
		UP, DOWN, LEFT, RIGHT
	}

	
	/**
	 * Helper function for creating a 2d grid to represent the maze, given a file name
	 * 
	 * @param filename - the name of the file to be read from, containing the maze data
	 */
	public static int[][] createGrid(String filename) throws IOException {
		//create the 2d array from the maze textfile
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line = br.readLine();
		int n = line.length(); //the grid will always be an nxn square
		int[][] grid = new int[n][n];
		int row = 0;
		while (line != null) {
			int col = 0;
			for (char c : line.toCharArray()) {
				int val = Character.getNumericValue(c);
				grid[row][col] = val;
				col++;
			}
			line = br.readLine();
			row++;
		}
		br.close();
		return grid;
	}
	
}
