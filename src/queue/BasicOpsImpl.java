package queue;

import java.util.Scanner;

public class BasicOpsImpl {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		BasicQueue<Integer> q = new BasicQueue<>();

		int data = scan.nextInt();
		while (data != -1) {
			q.enqueue(data);
			data = scan.nextInt();
		}
		while (q.getSize() > 0) {
			System.out.print(q.dequeue() + "\t");
		}
		scan.close();
	}

}
