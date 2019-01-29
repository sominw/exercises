// Sample Input for tree - 8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1  

package bst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import binarytree.BinaryTreeNode;

public class ConstructBSTFromSortedArray {
	static Scanner scan = new Scanner(System.in);

	public static BinaryTreeNode<Integer> constructBSTFromSortedArray(int[] arr, int start, int end) {

		BinaryTreeNode<Integer> root = null;

		if (start > end) {
			return null;
		}
		
		int mid = (end + start) / 2;
		root = new BinaryTreeNode<Integer>(arr[mid]);
		root.left = constructBSTFromSortedArray(arr, start, mid - 1);
		root.right = constructBSTFromSortedArray(arr, mid + 1, end);
		return root;

	}
	
	public static void inorderPrint(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;
		inorderPrint(root.left);
		System.out.print(root.data + "\t");
		inorderPrint(root.right);
	}
	
	public static BinaryTreeNode<Integer> takeInput() {
		Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
		System.out.print("Enter root data: ");
		int rootData = scan.nextInt();
		if (rootData == -1)
			return null;
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.add(root);
		while (!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> front = pendingNodes.poll();
			System.out.println("Enter left child of " + front.data + ": ");
			int leftChild = scan.nextInt();
			if (leftChild != -1) {
				BinaryTreeNode<Integer> leftNode = new BinaryTreeNode<Integer>(leftChild);
				pendingNodes.add(leftNode);
				front.left = leftNode;
			}
			System.out.println("Enter right child of " + front.data + ": ");
			int rightChild = scan.nextInt();
			if (rightChild != -1) {
				BinaryTreeNode<Integer> rightNode = new BinaryTreeNode<Integer>(rightChild);
				pendingNodes.add(rightNode);
				front.right = rightNode;
			}
		}
		return root;
	}

	public static void print(BinaryTreeNode<Integer> root) {
		Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
		if (root == null)
			return;
		pendingNodes.add(root);
		while (!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> front = pendingNodes.poll();
			System.out.print(front.data + ": ");
			System.out.print("\t");
			if (front.left != null) {
				pendingNodes.add(front.left);
				System.out.print(front.left.data);
			}
			System.out.print("\t");
			if (front.right != null) {
				pendingNodes.add(front.right);
				System.out.print(front.right.data);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// BinaryTreeNode<Integer> root = takeInput();
		// print(root);
		System.out.println();
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		BinaryTreeNode<Integer> root = constructBSTFromSortedArray(arr, 0, arr.length - 1);
		print (root);
	}
}
