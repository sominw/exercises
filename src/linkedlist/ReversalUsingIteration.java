package linkedlist;

import java.util.Scanner;

public class ReversalUsingIteration {

	public static LinkedListNode<Integer> iterativeReversal(LinkedListNode<Integer> node) {
		LinkedListNode<Integer> prev = null;
		LinkedListNode<Integer> next = null;
		
		while (node != null) {
			next = node.next;
			node.next = prev;
			prev = node;
			node = next;
		}
		return prev;
		
	}

	public static LinkedListNode<Integer> reverseUsingIteration(LinkedListNode<Integer> node) {
		return iterativeReversal(node);
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
		print (reverseUsingIteration(head));
		scan.close();
	}

}
