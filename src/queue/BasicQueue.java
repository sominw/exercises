package queue;

class Node<T> {
	T data;
	Node<T> next;

	public Node(T data) {
		this.data = data;
		this.next = null;
	}
}

public class BasicQueue<T> {
	private Node<T> front;
	private Node<T> rear;
	private int size;

	public BasicQueue() {
		this.front = null;
		this.rear = null;
		this.size = 0;
	}

	public int getSize() {
		return this.size;
	}

	public T front() {
		return this.front.data;
	}

	public void enqueue(T data) {
		if (front == null) {
			front = new Node<T>(data);
			rear = front;
			size++;
			return;
		}
		Node<T> temp = new Node<T>(data);
		rear.next = temp;
		rear = temp;
		size++;
	}

	public T dequeue() {
		if (front == null) {
			System.out.println("Underflow!");
			return null;
		}
		Node<T> temp = front;
		front = front.next;
		size--;
		return temp.data;
	}
}
