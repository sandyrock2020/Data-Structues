package tree.main;

import tree.compute.BinaryTreeSize;
import tree.pojo.Node;
import tree.traversal.ItrativeTraversal;
import tree.traversal.RecursiveTraversal;

public class TreeMain {

	// Driver method
	public static void main(String[] args) {
		Node root;
		root = new Node(10);
		root.left = new Node(6);
		root.right = new Node(4);
		root.left.left = new Node(6);
		root.left.left.left = new Node(1);
		root.left.left.right = new Node(5);
		root.right.left = new Node(4);
		//root.right.right = new Node(7);
		TreeInterface recursive = new RecursiveTraversal();
		TreeInterface itrative = new ItrativeTraversal();
		//recursive.operate(root,TreeConstants.PRE_ORDER);
		//itrative.operate(root, TreeConstants.PRE_ORDER);
		
		///TreeInterface levelOrder = new LevelOrderTraversal();
		//levelOrder.operate(root, null);
		
		BinaryTreeSize binaryTree = new BinaryTreeSize();
		//System.out.println("Height "+binaryTree.getHeight(root));
		//binaryTree.printKlevelNodes(root, 2);
		//binaryTree.printLeftViewTree(root, 1);
		boolean checkChildrenSumProperty = binaryTree.checkChildrenSumProperty(root);
		System.out.println(checkChildrenSumProperty?"Yes":"No");
	}
}
