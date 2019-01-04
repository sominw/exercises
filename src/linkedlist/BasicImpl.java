package linkedlist;

import linkedlist.LinkedList.Node;

class LinkedList {

	Node head;
	
	public void insertElement(int element) {
		Node tempHead = this.head;
		if (tempHead == null) {
			this.head = new LinkedList.Node(element);
			System.out.println("Successfully inserted element into new list.");
			return;
		}
		int count = 1;
		while (tempHead.next != null) {
			count++;
			tempHead = tempHead.next;
		}
		Node node = new LinkedList.Node(element);
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
		list.insertElement(3);
		list.insertElement(4);
		list.printList();
	}
}
