
public class TestQuickSelect {
	private static CompareInt[] convert(int[] arr) {
		CompareInt[] newArr = new CompareInt[arr.length];
		for (int i = 0; i < newArr.length; i++) {
			newArr[i] = new CompareInt(arr[i]);
		}
		return newArr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] baseArr = new int[1000];
		for (int i = 0; i < 1000; i++) {
			baseArr[i] = 1000 - i;
		}
		CompareInt[] arr = convert(baseArr);
		
		CompareInt kth = Sorting.quickSelect(720, arr, 0, arr.length);
		System.out.println(kth.val);

	}

}
