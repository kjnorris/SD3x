
public class Fib {

	private static double fib(int n) {
		double binet = (Math.pow(((1 + Math.sqrt(5))/ 2), n) - Math.pow(((1 - Math.sqrt(5))/ 2), n)) / Math.sqrt(5);
		return binet;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= 40; i++ ) {
			double fibBinet = fib(i);
			System.out.println(i + " " + (int) fibBinet);
		}
	}

}
