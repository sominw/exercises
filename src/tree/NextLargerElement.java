package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NextLargerElement {

	static Scanner scan = new Scanner(System.in);

	public static ArrayList<TreeNode<Integer>> findElementsLargerThanN(TreeNode<Integer> node, int n,
			ArrayList<TreeNode<Integer>> list) {

		if (node.data > n) {
			list.add(node);
		}
		for (int i = 0; i < node.children.size(); i++) {
			findElementsLargerThanN(node.children.get(i), n, list);
		}
		return list;
	}

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
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode<Integer> frontNode = queue.poll();
			String s = frontNode.data + ": ";
			int numChildren = frontNode.children.size();
			for (int i = 0; i < numChildren; i++) {
				s += frontNode.children.get(i).data + ", ";
				queue.add(frontNode.children.get(i));
			}
			System.out.println(s);
		}
	}

	public static int findTotalNumberOfNodes(TreeNode<Integer> node) {
		if (node == null)
			return 0; 
		int count = 1;
		for (int i = 0; i < node.children.size(); i++) {
			count += findTotalNumberOfNodes(node.children.get(i));
		}
		return count;
	}

	public static void main(String[] args) {
		TreeNode<Integer> root = takeInputLevelWise();
		System.out.println("Total number of nodes: " + findTotalNumberOfNodes(root));
		
		ArrayList<TreeNode<Integer>> list = findElementsLargerThanN(root, scan.nextInt(), new ArrayList<>());
		Collections.sort(list, new CompareTreeNodes());
		
		System.out.println("Next Larger Element in Tree: " + list.get(0).data);
	}
}

class CompareTreeNodes implements Comparator<TreeNode<Integer>>{

	@Override
	public int compare(TreeNode<Integer> o1, TreeNode<Integer> o2) {
		if (o1.data > o2.data)
			return 1;
		else
			return -1;
	}
	
}
