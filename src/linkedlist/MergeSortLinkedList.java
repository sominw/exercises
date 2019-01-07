package linkedlist;

import java.util.Scanner;

public class MergeSortLinkedList {

	public static LinkedListNode<Integer> getMiddleNode(LinkedListNode<Integer> node) {
		if (node == null)
			return null;
		LinkedListNode<Integer> temp = node;
		int size = 1;
		while (temp.next != null) {
			temp = temp.next;
			size++;
		}
		temp = node;
		if (size % 2 == 0) {
			int i = 0;
			while (i != (size / 2) - 1) {
				temp = temp.next;
				i++;
			}
			return temp;
		} else {
			int i = 0;
			while (i != size / 2) {
				temp = temp.next;
				i++;
			}
			return temp;
		}
	}
	
	public static LinkedListNode<Integer> sort(LinkedListNode<Integer> left, LinkedListNode<Integer> right) {
		
		LinkedListNode<Integer> result = null;
		
		if (left.data < right.data) {
			result = new LinkedListNode<Integer>(left.data);
			left = left.next;
		} else {
			result = new LinkedListNode<Integer>(right.data);
			right = right.next;
		}
		
		while (left != null && right != null) {
			
			LinkedListNode<Integer> tempResult = result;
			while (tempResult.next != null)
				tempResult = tempResult.next;
			
			if (left.data < right.data) {
				tempResult.next = new LinkedListNode<Integer>(left.data);
				left = left.next;
			}
			else {
				tempResult.next = new LinkedListNode<Integer>(right.data);
				right = right.next;
			}
		}
		while (left != null) {
			LinkedListNode<Integer> tempResult = result;
			while (tempResult.next != null)
				tempResult = tempResult.next;
			tempResult.next = new LinkedListNode<Integer>(left.data);
			left = left.next;
		}
		while (right != null) {
			LinkedListNode<Integer> tempResult = result;
			while (tempResult.next != null)
				tempResult = tempResult.next;
			tempResult.next = new LinkedListNode<Integer>(right.data);
			right = right.next;
		}
		return result;
	}
	
	public static LinkedListNode<Integer> mergeSort(LinkedListNode<Integer> node) {
		if (node == null || node.next == null) {
			return node;
		}
		
		LinkedListNode<Integer> middleNode = getMiddleNode(node);
		LinkedListNode<Integer> nextToMiddle = middleNode.next;
		middleNode.next = null;
		
		LinkedListNode<Integer> left = mergeSort(node);
		LinkedListNode<Integer> right = mergeSort(nextToMiddle);
		
		return sort(left, right);
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
		print (mergeSort(head));
		scan.close();
	}

}
