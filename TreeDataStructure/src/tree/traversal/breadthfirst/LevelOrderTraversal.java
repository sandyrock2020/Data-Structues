package tree.traversal.breadthfirst;

import java.util.LinkedList;
import java.util.Queue;

import tree.constants.TreeOperationEnum;
import tree.main.TreeInterface;
import tree.pojo.Node;

/**
 * @author sandeep
 *
 */
public class LevelOrderTraversal implements TreeInterface {

	/**
	 *
	 */
	@Override
	public void operate(Node root, TreeOperationEnum treeOperationEnum) {
		// itrativeLevelOrderTraversal(root);
		levelOrderTraversalWithNewLine(root);
	}

	/**
	 * @param root print level order traversal of tree
	 */
	public void itrativeLevelOrderTraversal(Node root) {
		if (root == null)
			return;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			Node node = q.poll();
			System.out.println(node.key + " ");
			if (node.left != null)
				q.add(node.left);
			if (node.right != null)
				q.add(node.right);
		}
	}

	public void levelOrderTraversalWithNewLine(Node root) {
		if (root == null)
			return;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null); // adding null as level end marker
		while (q.size() > 1) {
			Node node = q.poll();
			if (node == null) {
				System.out.println();
				q.add(node); // adding null at front of queue
				continue;
			}
			System.out.print(node.key + " ");
			if (node.left != null)
				q.add(node.left);
			if (node.right != null)
				q.add(node.right);
		}

	}
}
