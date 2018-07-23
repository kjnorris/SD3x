
public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] costs = new int[][] {{5, 1, 1}, 
									{2, 4, 7}, 
									{2, 4, 5}, 
									{5, 6, 3}};

		for (int i = 0; i < costs.length; i++) {
			for (int j = 0; j < costs[i].length; j++) {
				System.out.print(costs[i][j] + " ");
			}
			System.out.print("\n");			
		}
		
	}

}
