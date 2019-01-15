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
}
