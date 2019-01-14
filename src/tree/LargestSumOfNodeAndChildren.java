package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class LargestSumOfNodeAndChildren {

	static Scanner scan = new Scanner(System.in);

	public static TreeNode<Integer> findLargestSumOfNodeAndChildren(TreeNode<Integer> root, HashMap<Integer, TreeNode<Integer>> sumMap) {
		Integer sum = root.data;
		for (int i = 0; i < root.children.size(); i++) {
			sum += root.children.get(i).data;
		}
		sumMap.put(sum, root);
		for (int i = 0; i < root.children.size(); i++) {
			findLargestSumOfNodeAndChildren(root.children.get(i), sumMap);
		}
		Set<Integer> keySet = sumMap.keySet();
		Integer maxKey = Collections.max(keySet);
		return sumMap.get(maxKey);
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
			return 0; // Edge Case
		int count = 1;
		for (int i = 0; i < node.children.size(); i++) {
			count += findTotalNumberOfNodes(node.children.get(i));
		}
		return count;
	}

	public static void main(String[] args) {
		TreeNode<Integer> root = takeInputLevelWise();
		System.out.println("Total number of nodes: " + findTotalNumberOfNodes(root));
		System.out.println(findLargestSumOfNodeAndChildren(root, new HashMap<>()).data);
	}
}
