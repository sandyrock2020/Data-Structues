package tree.compute;

import tree.constants.TreeOperationEnum;
import tree.main.TreeInterface;
import tree.pojo.Node;

public class BinaryTreeSize implements TreeInterface {

	@Override
	public void operate(Node root, TreeOperationEnum treeOperationEnum) {
		getSizeOfBinaryTree(root);
	}

	public int getSizeOfBinaryTree(Node root) {
		if (root == null)
			return 0;
		return 1 + getSizeOfBinaryTree(root.left) + getSizeOfBinaryTree(root.right);
	}

	public int maximumInBinaryTree(Node root) {
		if (root == null)
			return Integer.MIN_VALUE;
		return Math.max(root.key, Math.max(maximumInBinaryTree(root.left), maximumInBinaryTree(root.right)));
	}

	public int getHeight(Node root) {
		if (root == null)
			return 0;

		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;

	}
}
