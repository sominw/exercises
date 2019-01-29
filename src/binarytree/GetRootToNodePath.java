// Sample Input: 1 2 3 4 8 -1 -1 5 -1 -1 9 6 -1 -1 10 7 -1 -1 -1 -1 -1 
// Output: 8 6 3 1

package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GetRootToNodePath {

	static Scanner scan = new Scanner(System.in);

	public static ArrayList<Integer> findPathRootToNode(BinaryTreeNode<Integer> root, int data) {
		if (root == null)
			return null;

		if (root.data == data) {
			ArrayList<Integer> path = new ArrayList<>();
			path.add(root.data);
			return path;
		}

		ArrayList<Integer> pathLeft = findPathRootToNode(root.left, data);
		if (pathLeft != null) {
			pathLeft.add(root.data);
			return pathLeft;
		}

		ArrayList<Integer> pathRight = findPathRootToNode(root.right, data);
		if (pathRight != null) {
			pathRight.add(root.data);
			return pathRight;
		} else {
			return null;
		}

	}

	public static int height(BinaryTreeNode<Integer> root) {
		if (root == null)
			return 0;
		return Math.max(height(root.left), height(root.right)) + 1;
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
		System.out.print("Enter node to find path: ");
		ArrayList<Integer> path = findPathRootToNode(root, scan.nextInt());
		System.out.println(path);
	}
}
