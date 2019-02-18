package heap;

public class Priority_QueueTest {

	public static void main(String[] args) throws Exception {

		int[] arr = { 5, 7, 3, 9, 1, 10 };
		Priority_Queue pq = new Priority_Queue();
		for (Integer ele:arr) {
			pq.insert(ele);
		}
		while (!pq.isEmpty()) {
			System.out.print(pq.removeMin() + "\t");
		}
	}

}
