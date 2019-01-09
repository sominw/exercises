package stack;

public class StackNode<T> {
	
	T data;
	StackNode<T> next;
	
	public StackNode(T data) {
		// TODO Auto-generated constructor stub
		this.data = data;
		this.next = null;
	}
}
