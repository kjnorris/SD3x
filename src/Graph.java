
import java.util.*;

/**
 * A undirected graph class
 * 
 * Also includes functions for running dfs and bfs
 *
 */
public class Graph {
	
	private int n; //number of vertices
	private LinkedList<Integer>[] adj; //adjacency list
	
	/**
	 * Constructs a graph with n vertices (containing no edges)
	 * 
	 * @param n - the number of vertices in the graph
	 */
	@SuppressWarnings("unchecked")
	public Graph(int n) {
		this.n = n;
		adj = (LinkedList<Integer>[]) new LinkedList[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new LinkedList<>();
		}
	}
	
	/**
	 * add an edge between vertices v and w
	 */
	public void addEdge(int v, int w) {
		adj[v].add(w); //add w to v's adjacency list
		adj[w].add(v);
	}
	
	/**
	 * outputs the neighbors of a vertex v
	 */
	public List<Integer> neighbors(int v) {
		return adj[v];
	}
	
	/**
	 * @return the number of vertices in the graph
	 */
	public int size() {
		return n;
	}
	
	/**
	 * returns the number of shortest paths from s to t
	 * 
	 * ex. if the shortest path from s to t is of length 4, and there
	 * are two distinct paths from s to t of length 4, then you should return 2
	 * 
	 * @param s the source vertex
	 * @param t the destination vertex
	 * @return
	 */
	public int numShortestPaths(int s, int t) {
		//TODO
		LinkedList<Integer> bfsQ = new LinkedList<Integer>();
		int[] distances = new int[n];
		int[] shortCount = new int[n];
		boolean[] discovered = new boolean[n];
		
		bfsQ.add(s);
		distances[s] = 0;
		shortCount[s] = 1;
		discovered[s] = false;
		
		while (!bfsQ.isEmpty()) {
			int node = bfsQ.poll();
			
			if (!discovered[node]) {
				int closest = -1;
				discovered[node]= true;
				
				for (Integer neighbor: this.neighbors(node)) {
					
					if (discovered[neighbor]) {
						if (closest == -1) {
							closest = distances[neighbor];
							distances[node] = closest + 1;
							shortCount[node] = shortCount[neighbor];
						} else if (distances[neighbor] < closest) {
							closest = distances[neighbor];
							distances[node] = closest + 1;
							shortCount[node] = shortCount[neighbor];
						} else if (distances[neighbor] == closest){
							shortCount[node] += shortCount[neighbor];
						}
					} else {
						bfsQ.add(neighbor);
					}
				}
			}
		}
		
		return shortCount[t];
	}
}
