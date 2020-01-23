package tree.main;

import tree.constants.TreeConstants;
import tree.pojo.Node;
import tree.traversal.ItrativeTraversal;
import tree.traversal.RecursiveTraversal;

public class TreeMain {

	// Driver method
	public static void main(String[] args) {
		Node root;
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		TreeInterface recursive = new RecursiveTraversal();
		TreeInterface itrative = new ItrativeTraversal();
		recursive.operate(root,TreeConstants.PRE_ORDER);
		itrative.operate(root, TreeConstants.PRE_ORDER);
		
	}
}
