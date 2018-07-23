

/**
 * A Heap implementation class
 * 
 * @param heap the array that holds the heap data
 * @param size the number of elements currently stored in the heap
 */
public class MinHeap {
	
	CompareInt[] heap;
	int size;

	/**
	 * Constructs a new heap with maximum capacity n
	 * Remember to index your heap at 1 instead of 0!
	 * @param n the maximum number of elements allowed in the heap
	 */
	public MinHeap(int n) {
		heap = new CompareInt[n+1];
		size = 0;
	}
	
	/**
	 * Adds an element to the heap
	 * 
	 * @param val the value to be added to the heap
	 */
	public void add(CompareInt val) {
		this.size++;
		this.heap[this.size] = val;
		swim();
	}
	
	/**
	 * Extracts the smallest element from the heap
	 */
	public CompareInt extractMin() {
		CompareInt temp = this.heap[1];
		this.heap[1] = this.heap[this.size];
		this.heap[this.size--] = temp;
		sink();
		return temp;
	}
	
	private void swim() {
		CompareInt temp;
		int curr = this.size;
		int parent = this.size / 2;
		
		while ((curr > 1) && (this.heap[curr].compareTo(this.heap[parent]) == -1)) {
			temp = this.heap[parent];
			this.heap[parent] = this.heap[curr];
			this.heap[curr] = temp;
			curr = parent;
			parent = curr / 2;
		}

	}
	
	private void sink() {
		int curr = 1;
		int lChild = curr * 2;
		int rChild = lChild + 1;
		
		while (lChild <= this.size) {
			int smallest = lChild;
			
			if (rChild <= this.size) {
				if (this.heap[smallest].compareTo(this.heap[smallest+1]) == 1) {
					smallest = rChild;
				}
			}
			
			if ((this.heap[curr].compareTo(this.heap[smallest]) == 1)) {
				CompareInt temp = this.heap[curr];
				this.heap[curr] = this.heap[smallest];
				this.heap[smallest] = temp;
			}

			curr = smallest;
			lChild = curr * 2;
			rChild = lChild + 1;
		}
	}
	
	
}
