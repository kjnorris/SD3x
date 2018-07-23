import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import org.junit.jupiter.api.Test;

class GreedyDynamicAlgorithmsTest {

	/*
	@Test
	void testOptimalIntervals() {
		GreedyDynamicAlgorithms.Interval red1 = new GreedyDynamicAlgorithms.Interval(0, 4);
		GreedyDynamicAlgorithms.Interval red2 = new GreedyDynamicAlgorithms.Interval(1, 5);
		GreedyDynamicAlgorithms.Interval red3 = new GreedyDynamicAlgorithms.Interval(4, 8);
		GreedyDynamicAlgorithms.Interval red4 = new GreedyDynamicAlgorithms.Interval(9, 10);
		GreedyDynamicAlgorithms.Interval red5 = new GreedyDynamicAlgorithms.Interval(9, 11);
		GreedyDynamicAlgorithms.Interval red6 = new GreedyDynamicAlgorithms.Interval(11, 12);
		GreedyDynamicAlgorithms.Interval red7 = new GreedyDynamicAlgorithms.Interval(10, 12);
		ArrayList<GreedyDynamicAlgorithms.Interval> red = new ArrayList<GreedyDynamicAlgorithms.Interval>();
		red.add(red1);
		red.add(red2);
		red.add(red3);
		red.add(red4);
		red.add(red5);
		red.add(red6);
		red.add(red7);
		
		GreedyDynamicAlgorithms.Interval blue1 = new GreedyDynamicAlgorithms.Interval(0, 2);
		GreedyDynamicAlgorithms.Interval blue2 = new GreedyDynamicAlgorithms.Interval(5, 5);
		GreedyDynamicAlgorithms.Interval blue3 = new GreedyDynamicAlgorithms.Interval(7, 10);
		GreedyDynamicAlgorithms.Interval blue4 = new GreedyDynamicAlgorithms.Interval(11, 13);
		GreedyDynamicAlgorithms.Interval blue5 = new GreedyDynamicAlgorithms.Interval(6, 6);
		ArrayList<GreedyDynamicAlgorithms.Interval> blue = new ArrayList<GreedyDynamicAlgorithms.Interval>();
		blue.add(blue1);
		blue.add(blue2);
		blue.add(blue3);
		blue.add(blue4);
		blue.add(blue5);
		
		assertEquals(3, GreedyDynamicAlgorithms.optimalIntervals(red, blue));
				
		// fail("Not yet implemented");
	}
	*/

	@Test
	void testOptimalGridPath() {
		int[][] grid = new int[][] {{5, 1, 1}, 
									{2, -3, 7},
									{2, 4, 5}, 
									{5, 6, 3}};
		LinkedList<GreedyDynamicAlgorithms.Direction> path = new LinkedList<GreedyDynamicAlgorithms.Direction>();
		path.push(GreedyDynamicAlgorithms.Direction.DOWN);
		path.push(GreedyDynamicAlgorithms.Direction.RIGHT);
		path.push(GreedyDynamicAlgorithms.Direction.DOWN);
		path.push(GreedyDynamicAlgorithms.Direction.DOWN);
		path.push(GreedyDynamicAlgorithms.Direction.RIGHT);

		assertEquals(path, GreedyDynamicAlgorithms.optimalGridPath(grid));
		// fail("Not yet implemented");
	}

}
