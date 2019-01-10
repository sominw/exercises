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
			this.front = new Node<T>(data);
			this.rear = this.front;
			this.size++;
			return;
		}
		Node<T> temp = new Node<T>(data);
		this.rear.next = temp;
		this.rear = temp;
		this.size++;
	}

	public T dequeue() {
		if (this.front == null) {
			System.out.println("Underflow!");
			return null;
		}
		Node<T> temp = front;
		this.front = this.front.next;
		this.size--;
		return temp.data;
	}
}
