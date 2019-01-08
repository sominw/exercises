package linkedlist;

import java.util.Scanner;

public class DecimalEquivalent {
	
	public static int calculateDecimalEquivalent(LinkedListNode<Integer> node) {
		int result = 0;
		int size = 0;
		LinkedListNode<Integer> temp = node;
		while (temp.next != null) {
			temp = temp.next;
			size++;
		}
		while (size >= 0 && node != null) {
			result += node.data*Math.pow(2, size);
			size--;
			node = node.next;
		}
		return result;
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
		
//		print(head);
		System.out.println(calculateDecimalEquivalent(head));
		scan.close();
	}
}
