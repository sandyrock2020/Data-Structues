package tree.constants;

public enum TreeOperationEnum {
	IN_ORDER("IN_ORDER", "Inorder traversal", 1), PRE_ORDER("PRE_ORDER", "Pre traversal", 1),
	POST_ORDER("POST_ORDER", "Inorder traversal", 1), LEVEL_ORDER("LEVEL_ORDER", "Level order traversal", 1);

	private String operationCode;
	private String operationName;
	private int numberOfArgs;

	private TreeOperationEnum(String operationCode, String operationName, int numberOfArgs) {
		this.operationCode = operationCode;
		this.operationName = operationName;
		this.numberOfArgs = numberOfArgs;
	}

}
