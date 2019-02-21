package heap;

public class InPlacePriorityQueue {

	public static void insertInPlace(int[] arr) {
		int index = 0;
		int size = 0;

		while (size < arr.length) {
			int parent = (index - 1) / 2;
			while (parent >= 0 && arr[parent] > arr[index]) {
				int temp = arr[parent];
				arr[parent] = arr[index];
				arr[index] = temp;
				index = parent;
				parent = (index - 1) / 2;
			}
			size++;
			index = size;
		}
	}

	public static void main(String[] args) {

		int[] arr = { 5, 3, 2, 6, 7, 1, 23, 4 };
		
		insertInPlace(arr);
		
		for (int i : arr) {
			System.out.print(i + "\t");
		}

	}

}
