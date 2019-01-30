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

	private BinaryTreeNode<Integer> delete(Integer data, BinaryTreeNode<Integer> node) {

		if (node == null)
			return null;

		if (data > node.data) {
			node.right = delete(data, node.right);
		} else {
			node.left = delete(data, node.left);
		}

		if (node.data == data && node.left == null && node.right == null) {
			node = null;
			return node;
		}

		if (node.data == data && node.left != null && node.right == null) {
			BinaryTreeNode<Integer> temp = node.left;
			node.left = null;
			return temp;
		} else if (node.data == data && node.left == null && node.right != null) {
			BinaryTreeNode<Integer> temp = node.right;
			node.right = null;
			return temp;
		} else {
			BinaryTreeNode<Integer> minNode = node.right;
			while (minNode.left != null) {
				minNode = minNode.left;
			}
			int minData = minNode.data;
			node.data = minData;
			node.right = delete(minData, node.right);
		}
		
		return node;

	}

	public void delete(Integer data) {
		delete(data, this.root);
	}
}
