// Input must ensure that a BST is constructed level-wise (using queue)

package bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SearchElementInBST {
	static Scanner scan = new Scanner(System.in);

	public static BinaryTreeNode<Integer> searchElement(BinaryTreeNode<Integer> root, Integer data) {
		if (root == null) {
			return null;
		}
		if (root.data == data) {
			return root;
		}
		if (root.data > data) {
			return searchElement(root.left, data);
		} else {
			return searchElement(root.right, data);
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
		System.out.print("Enter element to search: ");
		Integer data = scan.nextInt();
		BinaryTreeNode<Integer> searchedNode = searchElement(root, data);
		if (searchedNode != null)
			System.out.println("Node found: " + searchedNode.data);
		else
			System.out.println("Node not found!");
	}
}
