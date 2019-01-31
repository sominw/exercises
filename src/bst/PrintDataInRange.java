// Sample Input for tree - 8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1

package bst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class PrintDataInRange {
	static Scanner scan = new Scanner(System.in);

	public static ArrayList<Integer> printDataInRange(BinaryTreeNode<Integer> root, Integer max, Integer min, Set<Integer> set) {
		if (root == null)
			return null;

		if (root.data > max) {
			printDataInRange(root.left, max, min, set);
		} else if (root.data < min) {
			printDataInRange(root.right, max, min, set);
		} else if (root.data <= max && root.data >= min) {
			set.add(root.data);
			printDataInRange(root.left, max, min, set);
			printDataInRange(root.right, max, min, set);
		}
		
		ArrayList<Integer> list = new ArrayList<>(set);
		Collections.sort(list);
		
		return list;
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
		ArrayList<Integer> list = printDataInRange(root, max, min, new HashSet<>());
		
		for (Integer i : list) {
			System.out.print(i + " ");
		}
	}
}
