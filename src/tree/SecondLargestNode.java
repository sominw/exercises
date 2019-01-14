package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class SecondLargestNode {

	static Scanner scan = new Scanner(System.in);
	
	public static HashSet<TreeNode<Integer>> addNodesToHashSet(TreeNode<Integer> node, HashSet<TreeNode<Integer>> set) {
		if (node == null)
			return null;
		set.add(node);
		for (int i = 0; i < node.children.size(); i++) {
			addNodesToHashSet(node.children.get(i), set);
		}
		return set;
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
			return 0; //Edge Case
		int count = 1;
		for (int i = 0; i < node.children.size(); i++) {
			count += findTotalNumberOfNodes(node.children.get(i));
		}
		return count;
	}
	
	public static void main(String[] args) {
		TreeNode<Integer> root = takeInputLevelWise();
		System.out.println("Total number of nodes: " + findTotalNumberOfNodes (root));
		HashSet<TreeNode<Integer>> set = addNodesToHashSet(root, new HashSet<>());
		List<TreeNode<Integer>> list = new ArrayList<>(set);
		Collections.sort(list, new TreeComparator());
		if (list.size() > 1)
			System.out.println(list.get(1).data);
		else
			System.out.println("null");
		
	}
}

class TreeComparator implements Comparator<TreeNode<Integer>>{
	@Override
	public int compare(TreeNode<Integer> o1, TreeNode<Integer> o2) {
		// TODO Auto-generated method stub
		if (o1.data > o2.data)
			return -1;
		else 
			return 1;
	}
}