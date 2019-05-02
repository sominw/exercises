package heap;

public class Priority_QueueTest {

	public static void main(String[] args) throws Exception {

		int[] arr = {10,14,19,26,31,42,27,44,35,33};
		Priority_Queue pq = new Priority_Queue();
		for (Integer ele:arr) {
			pq.insert(ele);
//			System.out.println(pq.heap);
		}
		while (!pq.isEmpty()) {
			System.out.print(pq.removeMin() + "\t");
			System.out.println(pq.heap);
		}
	}

}
