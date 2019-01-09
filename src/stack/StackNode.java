package stack;

class Node<T> {
	T data;
	Node<T> next;
	
	public Node(T data) {
		this.data = data;
		this.next = null;
	}
}

public class StackNode<T> {
	
	Node<T> top;
	int size;
	
	public StackNode() {
		this.top = null;
		size = 0;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public void push(T data) {
		if (this.top == null) {
			this.top = new Node<T>(data);
		}
		else {
			Node<T> temp = new Node<T>(data);
			temp.next = this.top;
			this.top = temp;
		}
	}
	
	public T pop() {
		if (this.top == null) {
			System.out.println("Underflow!!");
			return null;
		}
		else {
			Node<T> temp = this.top;
			this.top = this.top.next;
			return temp.data;
		}
	}
	
	public T top() {
		if (this.top == null) {
			System.out.println("Underflow!!");
			return null;
		}
		else {
			return this.top.data;
		}
	}
}
