package tree.traversal;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.Consumer;

import tree.constants.TreeOperationEnum;
import tree.main.TreeInterface;
import tree.pojo.Node;

public class ItrativeTraversal implements TreeInterface {

	Map<TreeOperationEnum, Consumer<Node>> funcMap =  new HashMap<>();
	
	
	@Override
	public void operate(Node root, TreeOperationEnum treeOperationEnum) {
		funcMap.put(TreeOperationEnum.IN_ORDER, this::inOrder);
		funcMap.put(TreeOperationEnum.PRE_ORDER, this::preOrder);
		funcMap.put(TreeOperationEnum.POST_ORDER, this::postOrder);
		
		System.out.println(treeOperationEnum);
		funcMap.get(treeOperationEnum).accept(root);
	}

	private void postOrder(Node root) {
		if (root == null)
			return;
		Stack<Node> stack =  new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			Node node = stack.peek();
			stack.pop();
			if(node.right!=null) {
				stack.push(node.right);
			}
			if(node.left!=null) {
				stack.push(node.left);
			}
			System.out.println(node.key);
		}
	}

	private void inOrder(Node root) {

	}

	private void preOrder(Node root) {
		if (root == null)
			return;
		Stack<Node> stack =  new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			Node node = stack.peek();
			System.out.println(node.key);
			stack.pop();
			if(node.right!=null) {
				stack.push(node.right);
			}
			if(node.left!=null) {
				stack.push(node.left);
			}
			
		}

	}

}
