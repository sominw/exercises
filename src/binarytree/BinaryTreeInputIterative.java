package binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeInputIterative {
	static Scanner scan = new Scanner(System.in);

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
				root.left = leftNode;
			}
			System.out.println("Enter right child of " + front.data + ": ");
			int rightChild = scan.nextInt();
			if (rightChild != -1) {
				BinaryTreeNode<Integer> rightNode = new BinaryTreeNode<Integer>(rightChild);
				pendingNodes.add(rightNode);
				root.right = rightNode;
			}
		}
		return root;
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInput();
	}
}
