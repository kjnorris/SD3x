import java.util.Arrays;
import java.util.Random;

public class Sorting {
	
	/**
	 * Implement the mergesort function, which should sort the array of
	 * integers in place
	 * 
	 * You will probably want to use helper functions here, as described in the lecture recordings
	 * (ex. merge(), a helper mergesort function)
	 * @param arr
	 */
	public static void mergeSort(CompareInt[] arr) {
		CompareInt[] sortedArr = sort(arr, 0, arr.length);
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sortedArr[i];
		}
	}
	
	public static CompareInt[] sort(CompareInt[] arr, int lo, int hi) {
		if (hi - lo <= 1) return arr; 
		
		int mid = (lo + hi) / 2;
		
		CompareInt[] loArr = Arrays.copyOfRange(arr, lo, mid);
		CompareInt[] hiArr = Arrays.copyOfRange(arr, mid, hi);

		loArr = sort(loArr, 0, loArr.length);
		hiArr = sort(hiArr, 0, hiArr.length);

		CompareInt[] sortedArr = merge(loArr, hiArr);
		return sortedArr;
	}
	
	private static CompareInt[] merge(CompareInt[] loArr, CompareInt[] hiArr) {
		int i = 0, j = 0, k = 0;
		int finalLength = loArr.length + hiArr.length;
		CompareInt[] finalArr = new CompareInt[finalLength];
		
		while ((i < loArr.length) && (j < hiArr.length)) {
			int currCompare = loArr[i].compareTo(hiArr[j]);
			if (currCompare < 0) { 
				finalArr[k++] = loArr[i++];
			} else {
				finalArr[k++] = hiArr[j++];
			}
		}
		
		while (i < loArr.length) {
			finalArr[k++] = loArr[i++];
		}
		
		while (j < hiArr.length) { 
			finalArr[k++] = hiArr[j++];
		}

		return finalArr;
	}
	
	
	
	/**
	 * Implement the quickSelect
	 * 
	 * Again, you will probably want to use helper functions here
	 * (ex. partition(), a helper quickselect function)
	 */
	public static CompareInt quickSelect(int k, CompareInt[] arr) {
		//TODO
		CompareInt kthSmallest = quickSelect(k, arr, 0, arr.length);
		return kthSmallest;
	}
	
	public static CompareInt quickSelect(int k, CompareInt[] arr, int lo, int hi) {
		
		/*
		System.out.println("QuickSelect Called!");
		System.out.println("Element: " + k);
		System.out.println("Lo: " + lo);
		System.out.println("Hi: " + hi + "\n");
		*/
		
		if (lo == hi) {
			// System.out.println("Reduced array to single element); this must be it.");
			return arr[lo];
		}
		
		int pos = k - 1;
		
		int pivotIndex = partition(arr, lo, hi);

		if (pivotIndex == pos) {
			// System.out.println("Lucky strike! Pivot is kth element.");math
			return arr[pos];
		} else if(pivotIndex < pos) {
			// quickSelect(pos - pivotIndex, arr, pivotIndex + 1, hi);
			quickSelect(k, arr, pivotIndex + 1, hi);
		} else {
			quickSelect(k, arr, lo, pivotIndex);
		}
		
		return arr[pos];
	}
	
	private static int partition(CompareInt[] arr, int lo, int hi) {
		Random rand = new Random();
		int pivotIndex = rand.nextInt((hi - lo)) + lo;
		
		CompareInt[] tempArr = new CompareInt[arr.length];
		
		CompareInt pivot = arr[pivotIndex];
		
		arr[pivotIndex] = arr[hi-1];
		arr[hi-1] = pivot;
		int i = lo;
		int j = hi - 1;
		
		for (int k = lo; k < hi; k++) {
			if (arr[k].compareTo(pivot) < 0) {
				tempArr[i++] = arr[k];
			} else {
				tempArr[j--] = arr[k];
			}
		}
		
		tempArr[i] = pivot;

		for (int m = lo; m < hi; m++) {
			arr[m] = tempArr[m];
		}
		
		return (i);
	}

}
