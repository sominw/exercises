package heap;

import java.util.ArrayList;
import java.util.List;

public class HeapSort {
	
	public static void insertToHeap(List<Integer> heap, int val) {
		heap.add(val);
		int currIndex = heap.size() - 1;
		int parentIndex = (currIndex - 1) / 2;
		while (parentIndex >= 0) {
			if (heap.get(parentIndex) < heap.get(currIndex)) {
				int temp = heap.get(parentIndex);
				heap.set(parentIndex, heap.get(currIndex));
				heap.set(currIndex, temp);
				currIndex = parentIndex;
				parentIndex = (currIndex - 1) / 2;
			} else {
				break;
			}
		}
	}

	public static void heapify(List<Integer> heap, int i) {
		int maxIndex = i;

		if ((2 * i + 1) < heap.size() && heap.get(i) < heap.get(2 * i + 1)) {
			maxIndex = 2 * i + 1;
		}
		if ((2 * i + 2) < heap.size() && heap.get(maxIndex) < heap.get(2 * i + 2)) {
			maxIndex = 2 * i + 2;
		}
		if (maxIndex != i) {
			int temp = heap.get(i);
			heap.set(i, heap.get(maxIndex));
			heap.set(maxIndex, temp);
			heapify(heap, maxIndex);
		}
	}

	public static int getMax(List<Integer> heap) {

		if (heap == null)
			return 0;

		int top = heap.get(0);
		heap.set(0, heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);
		heapify(heap, 0);
		return top;
	}

	public static void main(String[] args) {

		int[] arr = { 10,14,19,26,31,42,27,44,35,33 };
		ArrayList<Integer> heap = new ArrayList<Integer>();
		
		for (Integer i: arr)
			insertToHeap(heap, i);
		
		System.out.println(heap);
		
		while (!heap.isEmpty())
			System.out.print(getMax(heap) + "\t");
		
	}

}
