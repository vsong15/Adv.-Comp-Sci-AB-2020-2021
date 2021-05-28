public class BinaryTree{

	private TreeNode root;

	// Default Constructor
	public BinaryTree(){
		root = null;
	}

	// Constructor with arguments
	public BinaryTree(TreeNode node){
		root = node;
	}

	// SET & GET METHODS
	public TreeNode getRoot(){
		return root;
	}	
	
	public void setRoot(TreeNode node){
		root = node;
	}
	
	// Other methods
	boolean isEmpty(){
		if(root == null){
			return true;
		} else {
			return false;
		}
	}	

	// Insert a node into the tree
	public void insert(Object data){
		// METHOD INSIDE NOT SHOWN
	}

	// Find a node in a tree
	public TreeNode find(Object data){
		// METHOD INSIDE NOT SHOWN
      return null;
	}
	

}