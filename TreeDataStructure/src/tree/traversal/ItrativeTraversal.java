package tree.traversal;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.function.Consumer;

import javax.annotation.PostConstruct;

import tree.constants.TreeConstants;
import tree.main.TreeInterface;
import tree.pojo.Node;

public class ItrativeTraversal implements TreeInterface {

	Map<String, Consumer<Node>> funcMap =  new HashMap<>();
	
	
	@Override
	public void operate(Node root,String type) {
		funcMap.put(TreeConstants.IN_ORDER, this::inOrder);
		funcMap.put(TreeConstants.PRE_ORDER, this::preOrder);
		funcMap.put(TreeConstants.POST_ORDER, this::postOrder);
		
		System.out.println(type);
		funcMap.get(type).accept(root);
	}

	private void postOrder(Node root) {

	}

	private void inOrder(Node root) {
		// TODO Auto-generated method stub

	}

	private void preOrder(Node root) {
		if (root == null)
			return;
		Stack<Node> stack =  new Stack<>();
		stack.add(root);
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
