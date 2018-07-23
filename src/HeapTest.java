
public class HeapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MinHeap heap = new MinHeap(15);
		heap.add(new CompareInt(5));
		heap.add(new CompareInt(12));
		heap.add(new CompareInt(3));
		heap.add(new CompareInt(8));
		heap.add(new CompareInt(4));
		heap.add(new CompareInt(7));
		heap.add(new CompareInt(2));
		heap.add(new CompareInt(6));
		heap.add(new CompareInt(11));
		
		for (int i = 1; i <= heap.size; i++) {
			System.out.println("Array record: " + i + " has value: " + heap.heap[i].val);
		}

		heap.extractMin();
		heap.extractMin();
		heap.extractMin();
		heap.extractMin();
		heap.extractMin();
		
		System.out.println("After extraction ...");;
		for (int i = 1; i <= heap.size; i++) {
			System.out.println("Array record: " + i + " has value: " + heap.heap[i].val);
		}
	}

}
