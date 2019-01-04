package linkedlist;

class Node {
	int data;
	Node next = null;

	public Node(int data) {
		this.data = data;
	}
}

public class BasicImpl {
	public static void main(String[] args) {

		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);

		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
}
