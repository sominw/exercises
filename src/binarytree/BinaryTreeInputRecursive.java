package binarytree;

import java.util.Scanner;

public class BinaryTreeInputRecursive {
	static Scanner scan = new Scanner(System.in);
	
	public static BinaryTreeNode<Integer> takeInput() {
		
		System.out.println("Enter data: ");
		int rootData = scan.nextInt();
		if (rootData == -1)
			return null;
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		root.left = takeInput();
		root.right = takeInput();
		return root;
	}
	
	public static void printRecursive(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;
		
		String print = root.data + ":";	
		if (root.left != null)
			print += " L:" + root.left.data +" ";
		if (root.right != null)
			print += " R:" + root.right.data +" ";
		System.out.println(print);
		printRecursive(root.left);
		printRecursive(root.right);
	}
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInput();
		printRecursive(root);
	}
}
