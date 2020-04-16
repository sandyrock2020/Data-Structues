package tree.compute;

import tree.constants.TreeOperationEnum;
import tree.main.TreeInterface;
import tree.pojo.Node;

public class BinaryTreeSize implements TreeInterface {

	int maxLevel = 0;

	@Override
	public void operate(Node root, TreeOperationEnum treeOperationEnum) {
		getSizeOfBinaryTree(root);
	}

	/**
	 * @param root
	 * @return number of node in binary tree
	 */
	public int getSizeOfBinaryTree(Node root) {
		if (root == null)
			return 0;
		return 1 + getSizeOfBinaryTree(root.left) + getSizeOfBinaryTree(root.right);
	}

	/**
	 * @param root
	 * @return node with minimum key value
	 */
	public int maximumInBinaryTree(Node root) {
		if (root == null)
			return Integer.MIN_VALUE;
		return Math.max(root.key, Math.max(maximumInBinaryTree(root.left), maximumInBinaryTree(root.right)));
	}

	/**
	 * @param root
	 * @return height of the binary tree
	 */
	public int getHeight(Node root) {
		if (root == null)
			return 0;
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}

	/**
	 * @param root
	 * @param k    // print node the given K level
	 */
	public void printKlevelNodes(Node root, int k) {
		if (root == null)
			return;
		if (k == 0)
			System.out.print(root.key + " ");
		printKlevelNodes(root.left, k - 1);
		printKlevelNodes(root.right, k - 1);
	}

	/**
	 * @param root
	 * @param level //print leftmost node at every level
	 */
	public void printLeftViewTree(Node root, int level) {
		if (root == null)
			return;
		if (level > maxLevel) {
			System.out.print(root.key + " ");
			maxLevel = level;
		}
		printLeftViewTree(root.left, level + 1);
		printLeftViewTree(root.right, level + 1);

	}

	public boolean checkChildrenSumProperty(Node root) {
		if (root == null)
			return true;
		if (root.left == null && root.right == null)
			return true;
		int sum = 0;
		if (root.left != null)
			sum += root.left.key;
		if (root.right != null)
			sum += root.right.key;
		return root.key == sum && checkChildrenSumProperty(root.left) && checkChildrenSumProperty(root.right);
	}
}
