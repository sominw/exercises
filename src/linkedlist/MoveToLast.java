package linkedlist;

import java.util.Scanner;

public class MoveToLast {

	public static LinkedListNode<Integer> moveToLast(LinkedListNode<Integer> node, Integer key) {

		LinkedListNode<Integer> next = null;
		LinkedListNode<Integer> prev = null;
		LinkedListNode<Integer> temp = null;
		LinkedListNode<Integer> tail = node;

		while (tail.next != null)
			tail = tail.next;

		LinkedListNode<Integer> tailTemp = tail;

		while (node.data.equals(key) && node != tail) {
			temp = node;
			node = node.next;
			tailTemp.next = temp;
			tailTemp = tailTemp.next;
			tailTemp.next = null;
		}

		LinkedListNode<Integer> curr = node;

		while (curr != tail) {
			if (curr.data.equals(key)) {
				temp = curr;
				curr = curr.next;
				prev.next = curr;
				next = curr.next;
				tailTemp.next = temp;
				tailTemp = tailTemp.next;
				tailTemp.next = null;
			} else {
				next = curr.next;
				prev = curr;
				curr = next;
			}
		}
		return node;
	}

	public static void print(LinkedListNode<Integer> head) {

		LinkedListNode<Integer> temp = head;
		while (temp != null) {
			System.out.print(temp.data + "\t");
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		LinkedListNode<Integer> head = null;
		int data = scan.nextInt();
		while (data != -1) {
			LinkedListNode<Integer> temp = new LinkedListNode<Integer>(data);
			if (head == null)
				head = temp;
			else {
				LinkedListNode<Integer> tempHead = head;
				while (tempHead.next != null) {
					tempHead = tempHead.next;
				}
				tempHead.next = temp;
			}
			data = scan.nextInt();
		}
		
		Integer key = scan.nextInt();
		print(moveToLast(head, key));
		scan.close();
	}

}
