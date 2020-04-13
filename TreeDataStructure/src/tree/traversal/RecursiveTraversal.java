package tree.traversal;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import tree.constants.TreeOperationEnum;
import tree.main.TreeInterface;
import tree.pojo.Node;

public class RecursiveTraversal implements TreeInterface {

	Map<TreeOperationEnum, Consumer<Node>> funcMap =  new HashMap<>();
	
	
	@Override
	public void operate(Node root, TreeOperationEnum treeOperationEnum) {
		funcMap.put(TreeOperationEnum.IN_ORDER, this::inOrder);
		funcMap.put(TreeOperationEnum.PRE_ORDER, this::preOrder);
		funcMap.put(TreeOperationEnum.POST_ORDER, this::postOrder);
		System.out.println(treeOperationEnum);
		funcMap.get(treeOperationEnum).accept(root);
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
