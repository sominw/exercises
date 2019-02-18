// Must be CBT
// Must follow heap order-ppty - swap if necessary

package heap;

import java.util.ArrayList;

public class Priority_Queue {
	private ArrayList<Integer> heap;

	public Priority_Queue() {
		heap = new ArrayList<>();
	}

	boolean isEmpty() {
		return heap.isEmpty();
	}

	int size() {
		return heap.size();
	}

	int getMin() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("Empty Queue");
		}
		return heap.get(0);
	}

	void insert(int element) {
		this.heap.add(element);
		int childIndex = heap.size() - 1;
		int parentIndex = (childIndex - 1) / 2;

		while (childIndex > 0) {

			if (heap.get(childIndex) < heap.get(parentIndex)) {
				int temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				childIndex = parentIndex;
				parentIndex = (childIndex - 1) / 2;
			} else {
				return;
			}
		}
	}

	int removeMin() throws Exception {

		if (this.heap.isEmpty()) {
			throw new Exception("PQ Empty!");
		}
		int temp = heap.get(0);
		heap.set(0, heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);
		int leftIndex = 1;
		int rightIndex = 2;
		int currIndex = 0;
		int minIndex = currIndex;

		while (leftIndex < heap.size()) {
			if (heap.get(leftIndex) < heap.get(minIndex)) {
				minIndex = leftIndex;
			}
			if (rightIndex < heap.size() && heap.get(rightIndex) < heap.get(minIndex)) {
				minIndex = rightIndex;
			}
			if (minIndex == currIndex) {
				break;
			} else {
				int temp1 = heap.get(currIndex);
				heap.set(currIndex, heap.get(minIndex));
				heap.set(minIndex, temp1);
				currIndex = minIndex;
				leftIndex = 2 * currIndex + 1;
				rightIndex = 2 * currIndex + 2;
			}
		}
		return temp;
	}
}
