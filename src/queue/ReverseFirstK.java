package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class ReverseFirstK {

	public static Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
		Stack<Integer> tempStack = new Stack<>();
		for (int i = 0; i < k; i++) {
			tempStack.push(q.poll());
		}
		for (int i = 0; i < k; i++) {
			q.add(tempStack.pop());
		}
		for (int i = 0; i < q.size() - k; i++) {
			q.add(q.poll());
		}
		return q;
	}

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		Scanner scan = new Scanner(System.in);

		int data = scan.nextInt();
		while (data != -1) {
			q.add(data);
			data = scan.nextInt();
		}
		Queue<Integer> result = reverseFirstK(q, 5);
		while (!result.isEmpty()) {
			System.out.print(result.poll() + "\t");
		}
		scan.close();
	}
}
