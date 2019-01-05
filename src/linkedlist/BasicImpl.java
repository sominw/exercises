package linkedlist;

class LinkedList {

	Node head;

	public boolean isPalindrome() {
		
		LinkedList revList = new LinkedList();
		this.reverseList();
		Node tempHead = this.head;
		while (tempHead != null) {
			revList.insertElement(tempHead.data);
			tempHead = tempHead.next;
		}
		this.reverseList();
		Node currHead = this.head;
		Node revHead = revList.head;

		while (currHead != null) {
			if (currHead.data != revHead.data)
				return false;
			currHead = currHead.next;
			revHead = revHead.next;
		}

		return true;
	}

	public void deleteByElement(int element) {
		if (this.head == null) {
			System.out.println("Empty List! Add some elements first!");
			return;
		}
		int prevSize = this.getSize();
		while (this.head.data == element && this.head != null) {
			this.head = this.head.next;
		}
		Node currNode = this.head;
		Node prevNode = null;
		while (currNode != null) {
			if (currNode.data == element) {
				System.out.println("Element deleted!");
				prevNode.next = currNode.next;
			}
			prevNode = currNode;
			currNode = currNode.next;
		}
		if (prevSize == this.getSize())
			System.out.println("Node not found!!");
	}

	public void deleteByIndex(int index) {
		if (this.head == null || index + 1 > this.getSize() || index < 0) {
			System.out.println("Could not delete. Either list is empty or index is invalid");
			return;
		}
		if (index == 0) {
			this.head = this.head.next;
			System.out.println("Element deleted at index: " + index);
			return;
		}
		Node tempNode = this.head;
		Node prevNode = null;
		int count = 0;
		while (count != index) {
			count++;
			prevNode = tempNode;
			tempNode = tempNode.next;
		}
		System.out.println("Element deleted at index: " + index);
		prevNode.next = tempNode.next;
	}

	public void reverseList() {
		if (this.head == null || this.getSize() <= 1) {
			System.out.println("Could not reverse, add some elements!");
			return;
		}
		Node currNode = this.head;
		Node prevNode = null;
		Node nextNode = null;

		while (currNode != null) {
			nextNode = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = nextNode;
		}
		this.head = prevNode;
		System.out.println("LIST REVERSED!");
	}

	public void search(int element) {
		Node tempHead = this.head;
		int index = 0;
		while (tempHead != null) {
			if (tempHead.data == element) {
				System.out.println("Element found at index: " + index);
				return;
			}
			tempHead = tempHead.next;
			index++;
		}
		System.out.println("Element not found!");
	}

	public int getSize() {
		Node tempHead = this.head;
		int count = 0;
		while (tempHead != null) {
			count++;
			tempHead = tempHead.next;
		}
		return count;
	}

	public void insertElement(int element) {
		Node tempHead = this.head;
		if (tempHead == null) {
			this.head = new Node(element);
			System.out.println("Successfully inserted element into a new list (index 0).");
			return;
		}
		int count = 1;
		while (tempHead.next != null) {
			count++;
			tempHead = tempHead.next;
		}
		Node node = new Node(element);
		tempHead.next = node;
		System.out.println("Successfully inserted element at index: " + count);
	}

	public void printList() {
		Node tempHead = this.head;
		if (tempHead == null) {
			System.out.println("Empty list!");
			return;
		}
		System.out.print("Current List -> ");
		while (tempHead != null) {
			System.out.print(tempHead.data + "\t");
			tempHead = tempHead.next;
		}
		System.out.println();
	}

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

}

public class BasicImpl {
	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		list.insertElement(1);
		list.insertElement(2);
		list.insertElement(1);
		list.insertElement(2);
		System.out.println(list.isPalindrome());
	}
}