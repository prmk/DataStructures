package structures.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class NaryTree<E> {

	private NaryNode<E> root;

	public NaryTree() {
		this.root = null;
	}

	public NaryTree(NaryNode<E> root) {
		this.root = root;
	}

	public NaryNode<E> getRoot() {
		return root;
	}

	public void setRoot(NaryNode<E> root) {
		this.root = root;
	}

	// prints the children in reverse order
	public void preOrderTraversal_Iterative() {
		this.preOrderTraversal_Iterative(this.root);
	}

	public void levelOrderTraversal_Iterative() {
		this.levelOrderTraversal_Iterative(this.root);
	}

	public void traversal() {
		this.traversal(this.root, 0);
	}

	@Override
	public String toString() {
		return this.root.toString();
	}

	// prints the children in reverse order
	private void preOrderTraversal_Iterative(NaryNode<E> node) {
		Stack<NaryNode<E>> stack = new Stack<NaryNode<E>>();
		stack.push(node);

		while (!stack.isEmpty()) {
			NaryNode<E> currnode = stack.pop();
			this.visit(currnode);
			for (NaryNode<E> child : currnode.getChildren())
				stack.push(child);
		}

	}

	private void levelOrderTraversal_Iterative(NaryNode<E> node) {
		Queue<NaryNode<E>> queue = new LinkedList<NaryNode<E>>();
		queue.add(node);

		while (!queue.isEmpty()) {
			NaryNode<E> currnode = queue.remove();
			this.visit(currnode);
			for (NaryNode<E> child : currnode.getChildren())
				queue.add(child);
		}
	}

	private void traversal(NaryNode<E> node, int depth) {
		if (node == null)
			return;

		this.visit(node, depth);

		for (NaryNode<E> child : node.getChildren())
			traversal(child, depth + 1);
	}

	private void visit(NaryNode<E> node, int depth) {
		for (int i = 0; i < depth; i++)
			System.out.print(" ");
		System.out.println(node + " ");
	}

	private void visit(NaryNode<E> node) {
		System.out.print(node + " ");
	}

	public static void main(String[] args) {
		NaryTree<Integer> tree = new NaryTree<Integer>();
		NaryNode<Integer> root = new NaryNode<Integer>(10);
		tree.setRoot(root);
		tree.getRoot().addChild(new NaryNode<Integer>(11)).addChild(new NaryNode<Integer>(12));
		tree.levelOrderTraversal_Iterative();
		System.out.println();
		tree.traversal();
	}
}

class NaryNode<E> {
	private E value;
	private ArrayList<NaryNode<E>> children;

	NaryNode(E value) {
		this.setValue(value);
		this.children = new ArrayList<NaryNode<E>>();
	}

	public NaryNode<E> addChild(NaryNode<E> NaryNode) {
		this.children.add(NaryNode);
		return this;
	}

	public NaryNode<E> addChildren(ArrayList<NaryNode<E>> children) {
		this.children.addAll(children);
		return this;
	}

	public E getValue() {
		return value;
	}

	public void setValue(E value) {
		this.value = value;
	}

	public ArrayList<NaryNode<E>> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<NaryNode<E>> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return this.value.toString();
	}

	public void print() {
		System.out.print(value + " ");
		for (NaryNode<E> child : children)
			System.out.print(child + " ");
		System.out.println();
	}
}
