// Sample Input for tree - 8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1  

package bst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class CheckIfBSTOrNot {
	static Scanner scan = new Scanner(System.in);

	public static boolean checkIfBSTOrNot(BinaryTreeNode<Integer> root, ArrayList<Integer> nodes) {
		if (root == null)
			return true;

		checkIfBSTOrNot(root.left, nodes);
		nodes.add(root.data);
		checkIfBSTOrNot(root.right, nodes);

		List<Integer> tempNodes = new ArrayList<>(nodes);
		Collections.sort(tempNodes);
		return tempNodes.equals(nodes);
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
		System.out.println(checkIfBSTOrNot(root, new ArrayList<>()));
	}
}
