package tree;

import java.util.Scanner;

public class TestTreeNode {

	static Scanner scan = new Scanner(System.in);

	public static TreeNode<Integer> input() {
		int data = scan.nextInt();
		TreeNode<Integer> node = new TreeNode<Integer>(data);
//		System.out.println("Enter number of children for this current node " + data + " :");
		int childCount = scan.nextInt();
		for (int i = 0; i < childCount; i++) {
			TreeNode<Integer> childNode = input();
			node.children.add(childNode);
		}
		return node;
	}
	
	public static void printTreeNode(TreeNode<Integer> node) {
		String s = node.data + ": ";
		for (int i = 0; i < node.children.size(); i++) {
			s = s + node.children.get(i).data + ", ";
		}
		System.out.println(s);
		for (int i = 0; i < node.children.size(); i++) {
			printTreeNode(node.children.get(i));
		}
	}

	public static void main(String[] args) {
		TreeNode<Integer> root = input();
		printTreeNode(root);
	}
}
