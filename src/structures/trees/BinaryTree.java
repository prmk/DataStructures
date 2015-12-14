package structures.trees;

/**
 * The class implements a Binary Tree. It provides functionalities like height,
 * traversals, BFS, DFS
 * 
 * Note: insertasComplete() operation currently builds a complete binary tree.
 * 
 * @author pramukh
 *
 * @param <E>
 *            provides the data type being used for the Tree.
 */
public class BinaryTree<E> {

	private Node<E> root;

	/**
	 * Creates a binary tree without any elements
	 */
	BinaryTree() {
		this.root = null;
	}

	BinaryTree(Node<E> root) {
		this.root = root;
	}

	/**
	 * @return the root
	 */
	public Node<E> getRoot() {
		return root;
	}

	/**
	 * @param root
	 *            the root to set
	 */
	public void setRoot(Node<E> root) {
		this.root = root;
	}

	public BinaryTree<E> insert(E value) {
		root = this.insert(root, value);
		return this;
	}

	/**
	 * The method works by filling up data from the left most part of the tree
	 * to the rightmost part of the tree, thereby forming a complete binary tree
	 * at each insert operation
	 * 
	 * @param value
	 * @return
	 */
	public BinaryTree<E> insertasCompleteTree(E value) {
		this.root = this.insertasCompleteTree(this.root, value);
		return this;
	}

	public void preOrderTraversal() {
		System.out.print("Pre order traversal: ");
		this.preOrderTraversal(this.root);
	}

	public void inOrderTraversal() {
		System.out.print("\nIn order traversal: ");
		this.inOrderTraversal(this.root);
	}

	public void postOrderTraversal() {
		System.out.print("\nPost order traversal: ");
		this.postOrderTraversal(this.root);
	}

	public int getHeight() {
		return this.getHeight(this.root);
	}

	public Node<E> insert(Node<E> node, E value) {
		if (node == null)
			node = new Node<E>(value);
		else {
			if (node.getRight() == null)
				node.setRight(this.insert(node.getRight(), value));
			else
				node.setLeft(this.insert(node.getLeft(), value));
		}
		return node;
	}

	/**
	 * -----------Incomplete----------- Calling this method results in the value
	 * being inserted at a position on or after the Node node.
	 * 
	 * @param node
	 * @param value
	 * @return
	 */
	private Node<E> insertasCompleteTree(Node<E> node, E value) {
		if (node == null)
			node = new Node<E>(value);
		else if (node.getLeft() == null)
			node.setLeft(new Node<E>(value));
		else if (node.getRight() == null)
			node.setRight(new Node<E>(value));
		else {
			if (this.getHeight(node.getLeft()) <= this.getHeight(node.getRight())) {
				if (node.getLeft().getLeft() == null || node.getLeft().getRight() == null)
					this.insertasCompleteTree(node.getLeft(), value);
				else
					this.insertasCompleteTree(node.getRight(), value);
			} else {
				if (node.getLeft().getRight() == null)
					this.insertasCompleteTree(node.getLeft(), value);
				else
					this.insertasCompleteTree(node.getRight(), value);
			}
		}

		return node;
	}

	private void preOrderTraversal(Node<E> node) {
		System.out.print(node + " ");
		if (node.getLeft() != null)
			this.preOrderTraversal(node.getLeft());
		if (node.getRight() != null)
			this.preOrderTraversal(node.getRight());
	}

	private void inOrderTraversal(Node<E> node) {
		if (node.getLeft() != null)
			this.inOrderTraversal(node.getLeft());
		System.out.print(node + " ");
		if (node.getRight() != null)
			this.inOrderTraversal(node.getRight());
	}

	private void postOrderTraversal(Node<E> node) {
		if (node.getLeft() != null)
			this.postOrderTraversal(node.getLeft());
		if (node.getRight() != null)
			this.postOrderTraversal(node.getRight());
		System.out.print(node + " ");
	}

	private int getHeight(Node<E> node) {
		if (node == null)
			return 0;
		return Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1;
	}

	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.insert(6).insert(24).insert(19).insert(94).insert(5).insert(1).insert(10).insert(3).insert(8);
		System.out.println(tree.getHeight());
		tree.preOrderTraversal();
		tree.inOrderTraversal();
		tree.postOrderTraversal();
	}
}

class Node<E> {
	private E value;
	private Node<E> left;
	private Node<E> right;

	Node(E value) {
		this.value = value;
	}

	Node(E value, Node<E> left, Node<E> right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	/**
	 * @return the value
	 */
	public E getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(E value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value.toString();
	}

	/**
	 * @return the left
	 */
	public Node<E> getLeft() {
		return left;
	}

	/**
	 * @param left
	 *            the left to set
	 */
	public void setLeft(Node<E> left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public Node<E> getRight() {
		return right;
	}

	/**
	 * @param right
	 *            the right to set
	 */
	public void setRight(Node<E> right) {
		this.right = right;
	}
}
