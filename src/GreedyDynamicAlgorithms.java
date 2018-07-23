
import java.util.*;

public class GreedyDynamicAlgorithms {

	/**
	 * Goal: find the smallest number of red intervals to select, such that
	 * every blue interval overlaps with at least one of the selected red intervals.
	 * Output this number
	 * 
	 * @param red - the list of red intervals
	 * @param blue - the list blue intervals
	 * @return
	 */
	public static int optimalIntervals(ArrayList<Interval> red, ArrayList<Interval> blue) {
		if (blue.isEmpty()) {
			return 0;
		}
		
		ArrayList<Interval> newBlue = new ArrayList<Interval>();
		
		Interval.sortByFinishTime(blue);
		Interval.sortByStartTime(red);
		
		ArrayList<Interval> covers = findCovers(red, blue.get(0));
		
		if (covers.isEmpty()) {
			return -1;
		}
		
		int bestCover = 0;
		int coveredBlue = 0;
		
		for (Interval curr: covers) {
			int currCovered = countCovers(curr, blue);
			if (currCovered > coveredBlue) {
				coveredBlue = currCovered;
				bestCover = red.indexOf(curr);
			}
		}
		
		for (Interval curr: blue) {
			if (!((red.get(bestCover).start <= curr.finish) && (red.get(bestCover).finish >= curr.start))) {
				newBlue.add(curr);
			}
		}

		int newCovers = optimalIntervals(red, newBlue);
		
		if (newCovers == -1) {
			return -1;
		} else {
			System.out.println("Returning: " + (newCovers+1));
			return (newCovers + 1);
		}

	}
	
	private static ArrayList<Interval> findCovers(ArrayList<Interval> red, Interval blue) {
		ArrayList<Interval> covers = new ArrayList<Interval>();
		
		for (Interval curr: red) {
			if ((curr.start <= blue.finish) && (curr.finish >= blue.start)) {
				covers.add(curr);
			}
		}
		
		return covers;
	}
	
	private static int countCovers(Interval red, ArrayList<Interval> blue) {
		int covered = 0;
		for (Interval curr: blue) {
			if ((red.start <= curr.finish) && (red.finish >= curr.start)) {
				covered++;
			}
		}
		return covered;
	}
	

	/**
	 * Goal: find any path of lowest cost from the top-left of the grid (grid[0][0])
	 * to the bottom right of the grid (grid[m-1][n-1]).  Output this sequence of directions
	 * 
	 * @param grid - the 2d grid containing the cost of each location in the grid.
	 * @return
	 */
	public static List<Direction> optimalGridPath(int[][] grid) {
		//TODO
		LinkedList<Direction> path = new LinkedList<Direction>();
		int numCols = grid[0].length;
		int numRows = grid.length;
		int[][] costs = new int[numRows][numCols];
		
		costs[0][0] = grid[0][0];
		
		for (int i = 1; i < numRows; i++) {
			costs[i][0] = grid[i][0] + costs[i-1][0];
		}
		
		for (int j = 1; j < numCols; j++) {
			costs[0][j] = grid[0][j] + costs[0][j-1];
		}
		
		for (int i = 1; i < numRows; i++) {
			for (int j = 1; j < numCols; j++) {
				if (costs[i][j-1] < costs[i-1][j]) {
					costs[i][j] = grid[i][j] + costs[i][j-1];
				} else {
					costs[i][j] = grid[i][j] + costs[i-1][j];
				}
			}
		}
		     
		/*
		for (int i = 0; i < costs.length; i++) {
			for (int j = 0; j < costs[i].length; j++) {
				System.out.print(costs[i][j] + " ");
			}
			System.out.print("\n");			
		}
		*/

		int currRow = numRows - 1;
		int currCol = numCols - 1;
		boolean atOrigin = false;
		
		while (!atOrigin) {
			if (currCol == 0) {
				path.push(Direction.DOWN);
				currRow--;
			} else if (currRow == 0) {
				path.push(Direction.RIGHT);
				currCol--;
			} else if (costs[currRow][currCol -1] < costs[currRow -1][currCol]) {
				path.push(Direction.RIGHT);
				currCol--;
			} else {
				path.push(Direction.DOWN);
				currRow--;
			}
			
			if ((currRow == 0) && (currCol == 0)) {
				atOrigin = true;
			}
		}
		
		return path;
	}
	
	/**
	 * A simple Direction enum
	 * directions can be either DOWN or RIGHT
	 * You will output a list of these in the grid-path problem
	 */
	public static enum Direction {
		DOWN, RIGHT
	}

	/**
	 * A private Interval class to help with the interval question
	 */
	public static class Interval {
		
		int start;
		int finish;
		
		public Interval(int start, int finish) {
			this.start = start;
			this.finish = finish;
		}
		
		/**
		 * sorts a list of intervals by start time, you are free to use this on the first question
		 */
		public static void sortByStartTime(ArrayList<Interval> l) {
			Collections.sort(l, new Comparator<Interval>() {
				public int compare(Interval o1, Interval o2) {
					Interval i1 = (Interval) o1;
					Interval i2 = (Interval) o2;
					return i1.start - i2.start;
				}
			});
		}
		
		/**
		 * sorts a list of intervals by finish time, you are free to use this on the first question
		 */
		public static void sortByFinishTime(ArrayList<Interval> l) {
			Collections.sort(l, new Comparator<Interval>() {
				public int compare(Interval o1, Interval o2) {
					Interval i1 = (Interval) o1;
					Interval i2 = (Interval) o2;
					return i1.finish - i2.finish;
				}
			});
		}
	}
	
}
