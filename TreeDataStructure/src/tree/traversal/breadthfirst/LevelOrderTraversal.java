package tree.traversal.breadthfirst;

import java.util.LinkedList;
import java.util.Queue;

import tree.main.TreeInterface;
import tree.pojo.Node;

/**
 * @author sandeep
 *
 */
public class LevelOrderTraversal implements TreeInterface {

	@Override
	public void operate(Node root, String type) {
		itrativeLevelOrderTraversal(root);		
	}

	void itrativeLevelOrderTraversal(Node root) {
		if(root==null)
			return;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()) {
			Node node = q.poll();
			System.out.println(node.key+" ");
			if(node.left!=null)
				q.add(node.left);
			if(node.right!=null)
				q.add(node.right);
		}
	}
}
