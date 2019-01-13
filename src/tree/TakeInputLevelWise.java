package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TakeInputLevelWise {

	static Scanner scan = new Scanner(System.in);

	public static TreeNode<Integer> takeInputLevelWise() {
		System.out.print("Enter Root Data: ");
		int data = scan.nextInt();
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		TreeNode<Integer> root = new TreeNode<Integer>(data);
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode<Integer> frontNode = queue.poll();
			System.out.print("Enter number of children of node " + frontNode.data + ": ");
			int numChildren = scan.nextInt();
			for (int i = 0; i < numChildren; i++) {
				System.out.print("Enter " + (i + 1) + "th child of " + frontNode.data + ": ");
				int child = scan.nextInt();
				TreeNode<Integer> node = new TreeNode<Integer>(child);
				frontNode.children.add(node);
				queue.add(node);
			}
		}
		return root;
	}

	public static void printLevelWise(TreeNode<Integer> root) {
		
	}
	
	public static void print(TreeNode<Integer> node) {
		String s = node.data + ": ";
		for (int i = 0; i < node.children.size(); i++) {
			s = s + node.children.get(i).data + ", ";
		}
		System.out.println(s);
		for (int i = 0; i < node.children.size(); i++) {
			print(node.children.get(i));
		}
	}

	public static void main(String[] args) {
		TreeNode<Integer> root = takeInputLevelWise();
		print (root);
	}
}
