package tree;

public class TestTreeNode {
	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<Integer>(10);
		TreeNode<Integer> node1 = new TreeNode<Integer>(11);
		TreeNode<Integer> node2 = new TreeNode<Integer>(12);
		TreeNode<Integer> node3 = new TreeNode<Integer>(13);
		TreeNode<Integer> node4 = new TreeNode<Integer>(10);
		node3.children.add(node4);
		root.children.add(node1);
		root.children.add(node2);
		root.children.add(node3);
		
	}
}
