// Sample Input for tree - 40 30 50 10 20 45 60 5 0 15 25 -1 -1 55 75 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1

package bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PrintDataInRange {
	static Scanner scan = new Scanner(System.in);

	public static void printDataInRange(BinaryTreeNode<Integer> root, Integer max, Integer min) {
		if (root == null)
			return;

		if (root.data >= max) {
			printDataInRange(root.left, max, min);
		} else if (root.data <= min) {
			printDataInRange(root.right, max, min);
		} else if (root.data < max && root.data > min) {
			System.out.print(root.data + "\t");
			printDataInRange(root.left, max, min);
			printDataInRange(root.right, max, min);
		}
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
		BinaryTreeNode<Integer> root = takeInput();
		print(root);
		System.out.println();
		System.out.print("Enter max: ");
		Integer max = scan.nextInt();
		System.out.print("Enter min: ");
		Integer min = scan.nextInt();
		printDataInRange(root, max, min);
	}
}
