package tree.compute;

import tree.pojo.Node;

public class TreeConstruction {

	static int preIndex = 0;

	public static Node treeUsingInorderAndPreOrder(int[] pre, int[] in, int is, int ie) {
		if (is > ie)
			return null;
		Node root = new Node(pre[preIndex++]);
		int index = 0;
		for (int i = is; i <=ie; i++) {
			if (in[i] == root.key) {
				index = i;
				break;
			}
		}
		root.left = treeUsingInorderAndPreOrder(pre, in, is, index - 1);
		root.right = treeUsingInorderAndPreOrder(pre, in, index + 1, ie);
		return root;
	}
}
