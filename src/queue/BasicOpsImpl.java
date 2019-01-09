package queue;

public class BasicOpsImpl {

	public static void main(String[] args) {
		BasicQueue<Integer> q = new BasicQueue<>();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		
		q.dequeue();
		
		q.enqueue(5);
		
		while (q.getSize() > 0) {
			System.out.print(q.dequeue() + "\t");
		}
		
		

	}

}
