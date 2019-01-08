package linkedlist;

import java.util.Scanner;

public class ReversalUsingRecursion {
	
	public static LinkedListNode<Integer> tailAndRecurse(LinkedListNode<Integer> node, LinkedListNode<Integer> prev){
		if (node.next == null) {
			node.next = prev;
			return node;
		}
		
		LinkedListNode<Integer> next = node.next;
		node.next = prev;
		return tailAndRecurse(next, node);
	}
	
	public static LinkedListNode<Integer> reverseUsingRecursion(LinkedListNode<Integer> node){
		return tailAndRecurse(node, null);
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
		
		print (reverseUsingRecursion(head));
		scan.close();
	}

}
