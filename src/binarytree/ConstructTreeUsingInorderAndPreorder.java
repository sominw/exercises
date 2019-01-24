package binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ConstructTreeUsingInorderAndPreorder {
	static Scanner scan = new Scanner(System.in);

	public static BinaryTreeNode<Integer> BuildTreeHelper(int in[], int pre[], int inS, int inE, int preS, int preE) {
		if (inS > inE)
			return null;
		int rootData = pre[preS];
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);

		int rootIndex = -1;
		for (int i = inS; i <= inE; i++) {
			if (in[i] == rootData) {
				rootIndex = i;
				break;
			}
		}

		if (rootIndex == -1)
			return null;

		int leftInS = inS;
		int leftInE = rootIndex - 1;
		int leftPreS = preS + 1;
		int leftPreE = leftInE - leftInS + leftPreS;
		int rightInS = rootIndex + 1;
		int rightInE = inE;
		int rightPreS = leftPreE + 1;
		int rightPreE = preE;

		root.left = BuildTreeHelper(in, pre, leftInS, leftInE, leftPreS, leftPreE);
		root.right = BuildTreeHelper(in, pre, rightInS, rightInE, rightPreS, rightPreE);

		return root;
	}

	public static BinaryTreeNode<Integer> buildTree(int in[], int[] pre) {
		return BuildTreeHelper(in, pre, 0, in.length - 1, 0, pre.length - 1);
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
//		BinaryTreeNode<Integer> root = takeInput();
		int[] in = { 4, 2, 5, 1, 3, 7 };
		int[] pre = { 1, 2, 4, 5, 3, 7 };
		
		BinaryTreeNode<Integer> root = buildTree(in, pre);
		print (root);

	}
}
