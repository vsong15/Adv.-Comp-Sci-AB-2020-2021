public class TreeNode{

	private Object data;
	private TreeNode left;
	private TreeNode right;

	// Default constructor
	public TreeNode(Object nodevalue){
		data = nodevalue;
		left = null;
		right = null;
	}
	
	// Constructor with arguments
	public TreeNode(Object nodevalue, TreeNode leftnode, TreeNode rightnode){
		data = nodevalue;
		left = leftnode;
		right = rightnode;
	}

	// GET METHODS

	public Object getData(){
		return data;
	}

	public TreeNode getLeft(){
		return left;
	}
	
	public TreeNode getRight(){
		return right;
	}		

	// SET METHODS
	public void setData(Object nodevalue){
		data = nodevalue;
	}

	public void setLeft(TreeNode leftnode){
		left = leftnode;
	}

	public void setData(TreeNode rightnode){
		right = rightnode;
	}

}