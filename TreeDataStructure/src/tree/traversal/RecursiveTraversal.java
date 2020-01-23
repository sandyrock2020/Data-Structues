package tree.traversal;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import tree.constants.TreeConstants;
import tree.main.TreeInterface;
import tree.pojo.Node;

public class RecursiveTraversal implements TreeInterface {

	Map<String, Consumer<Node>> funcMap =  new HashMap<>();
	
	
	@Override
	public void operate(Node root,String type) {
		funcMap.put(TreeConstants.IN_ORDER, this::inOrder);
		funcMap.put(TreeConstants.PRE_ORDER, this::preOrder);
		funcMap.put(TreeConstants.POST_ORDER, this::postOrder);
		System.out.println(type);
		funcMap.get(type).accept(root);
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
