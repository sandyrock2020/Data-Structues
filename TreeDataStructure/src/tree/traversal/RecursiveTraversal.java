package tree.traversal;

import tree.main.TreeInterface;
import tree.pojo.Node;

public class RecursiveTraversal implements TreeInterface {

	@Override
	public void operate(Node root) {
		System.out.println("PreOrder");
		preOrder(root);
		System.out.println("InOrder");
		inOrder(root);
		System.out.println("PostOrder");
		postOrder(root);
	}

	void preOrder(Node root) {
		if (root == null)
			return;
		System.out.println(root.key);
		preOrder(root.left);
		preOrder(root.right);

	}

	void postOrder(Node root) {
		if (root == null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.key);

	}

	void inOrder(Node root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.println(root.key);
		inOrder(root.right);

	}

}
