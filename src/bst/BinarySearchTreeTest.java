package bst;

public class BinarySearchTreeTest {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(10);
		bst.insert(5);
		bst.insert(20);
		bst.insert(7);
		bst.insert(3);
		bst.insert(15);
		
		bst.delete(10);
		
		bst.printTree();
	}
}
