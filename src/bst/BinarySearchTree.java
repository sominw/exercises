package bst;

public class BinarySearchTree {

	public BinaryTreeNode<Integer> root;

	public BinarySearchTree() {
		root = null;
	}

	private boolean hasData(Integer data, BinaryTreeNode<Integer> node) {
		if (node == null)
			return false;
		if (node.data == data)
			return true;
		if (data < node.data) {
			return hasData(data, node.left);
		} else {
			return hasData(data, node.right);
		}
	}

	public boolean hasData(Integer data) {
		return hasData(data, this.root);
	}

	private BinaryTreeNode<Integer> insert(Integer data, BinaryTreeNode<Integer> node) {
		if (node == null) {
			node = new BinaryTreeNode<Integer>(data);
			return node;
		}
		if (data > node.data) {
			node.right = insert(data, node.right);
		} else {
			node.left = insert(data, node.left);
		}
		return node;
	}

	public void insert(Integer data) {
		insert(data, this.root);
	}

	public void delete() {

	}
}
