import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class KthSmallestTest {

	private static CompareInt[] convert(int[] arr) {
		CompareInt[] newArr = new CompareInt[arr.length];
		for (int i = 0; i < newArr.length; i++) {
			newArr[i] = new CompareInt(arr[i]);
		}
		return newArr;
	}
	
	@Test
	public void KthSmallestTestSampleHeapTest() {
		CompareInt[] arr = convert(new int[]{4, 1, 3});
		assertEquals(3, KthSmallest.heapImpl(2, arr));
	}
	
	@Test
	public void KthSmallestTestSampleMergeTest() {
		CompareInt[] arr = convert(new int[]{4, 1, 3});
		assertEquals(3, KthSmallest.mergeSortImpl(2, arr));
	}
	
	@Test
	public void KthSmallestTestSampleQuickSelectTest() {
		CompareInt[] arr = convert(new int[]{4, 1, 3});
		assertEquals(3, KthSmallest.quickSelectImpl(2, arr));
	}

}
