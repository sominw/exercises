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
}
