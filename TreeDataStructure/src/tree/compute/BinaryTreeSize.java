package tree.compute;

import java.util.LinkedList;
import java.util.Queue;

import tree.constants.TreeOperationEnum;
import tree.main.TreeInterface;
import tree.pojo.Node;

public class BinaryTreeSize implements TreeInterface {

	int maxLevel = 0;
	Node pre = null;

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
	 * @param level
	 * @see print leftmost node at every level
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

	/**
	 * @param root
	 * @return true if each parent node is equal to sum of its children
	 */
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

	/**
	 * @param root
	 * @return height of tree at any node and -1 if difference between height of
	 *         left and right subtree is greater than 1
	 */
	public int checkBalanceTree(Node root) {
		if (root == null)
			return 0;
		int l = checkBalanceTree(root.left);
		if (l == -1)
			return -1;
		int r = checkBalanceTree(root.right);
		if (r == -1)
			return -1;
		if (Math.abs(l - r) > 1)
			return -1;
		else
			return Math.max(l, r) + 1;
	}

	public int getMaxWidth(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		int max = 0;
		while (!q.isEmpty()) {
			int count = q.size();
			if (count > max)
				max = count;
			for (int i = 0; i < count; i++) {
				Node node = q.poll();
				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
			}
		}
		return max;
	}

	public Node binaryTreeToDDL(Node root) {
		if (root == null)
			return root;
		Node head = binaryTreeToDDL(root.left);
		if (pre == null) {
			head = root;
		} else {
			pre.right = root;
			root.left = pre;
		}
		pre = root;
		binaryTreeToDDL(root.right);
		return head;
	}
	
	public int maxDiameter(Node root) {
		if(root==null)
			return 0;
		int dia = maxDiameter(root.left)+maxDiameter(root.right)+1;
		return dia ;
		
	}

}
