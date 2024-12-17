package neetcodealgo;

import java.util.ArrayList;
import java.util.List;

//leftChild = heap[2 * i]
//right child = heap[2 * i +1]
//parent = heap[i/2]
//parent always contain min value 
public class Heap {

	List<Integer> heap;

	public Heap() {
		heap = new ArrayList<Integer>();
		heap.add(0);
	}

	public void push(int val) {
		heap.add(val);
		int i = heap.size() - 1;

		// percolate up
		// new value less then parent so swap
		while (i > 0 && heap.get(i) < heap.get(i / 2)) {
			int temp = heap.get(i);
			heap.set(i, heap.get(i / 2)); // set i value to parent
			heap.set(i / 2, temp); // set parent vale to new position
			i = i / 2;
		}
	}

	// remove top parent element
	public int pop() {
		if (heap.size() == 1) {
			return 0;
		}

		if (heap.size() == 2) {
			return heap.remove(heap.size() - 1);
		}

		int res = heap.get(1); // get root elemnt;
		heap.set(1, heap.remove(heap.size() - 1)); // set last elemt as root
		int i = 1;

		// Percolate down
		while (2 * i < heap.size()) {

			if (2 * i + 1 < heap.size() && heap.get(2 * i + 1) < heap.get(2 * i) && heap.get(i) > heap.get(2 * i + 1)) {
				int temp = heap.get(i);
				heap.set(i, heap.get(2 * i + 1));
				heap.set(2*i +1, temp);
				i = 2 * i + 1;
			}
			// swap right
			else if (heap.get(i) > heap.get(2 * i)) {
				// swap left
				int temp = heap.get(i);
				heap.set(i, heap.get(2 * i));
				heap.set(2 * i, temp);
				i = i * 2;
			} else {
				break;
			}
		}
		return res;
	}
}
