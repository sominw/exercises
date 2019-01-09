package stack;

public class Stack<T> {
	
	T data;
	Stack<T> next;
	
	public Stack(T data) {
		// TODO Auto-generated constructor stub
		this.data = data;
		this.next = null;
	}
}
