package linkedlist;

import java.util.Scanner;

public class SwapEveryPair {

	public static LinkedListNode<Integer> swapEveryPair(LinkedListNode<Integer> node) {
		int size = 0;
		LinkedListNode<Integer> temp = node;
		while (temp != null) {
			temp = temp.next;
			size++;
		}
		if (size % 2 == 0) {
			temp = node;
			while (temp != null && size >= 0) {
				int tempData = temp.data;
				temp.data = temp.next.data;
				temp.next.data = tempData;
				temp = temp.next.next;
				size -= 2;
			}
			return node;
		} else {
			temp = node;
			while (temp != null && size > 1) {
				int tempData = temp.data;
				temp.data = temp.next.data;
				temp.next.data = tempData;
				temp = temp.next.next;
				size -= 2;
			}
			return node;
		}
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

		print(swapEveryPair(head));
		scan.close();
	}

}
