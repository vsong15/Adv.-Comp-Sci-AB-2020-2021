
// Definition of the TreeNdoe class for Integers
/* NOTE:  Code adapted from Barron’s AP Computer Science 
Levels A and AB, 4th Edition, 2008 */

public class TreeNode{

	private Integer data;
	private TreeNode left;
	private TreeNode right;

	// Default constructor
	public TreeNode(Integer val){
		data = val;
		left = null;
		right = null;
	}
	
	// Constructor with arguments
	public TreeNode(Integer val, TreeNode leftnode, TreeNode rightnode){
		data = val;
		left = leftnode;
		right = rightnode;
	}

	// GET METHODS
	public Integer getData(){
		return data;
	}

	public TreeNode getLeft(){
		return left;
	}
	
	public TreeNode getRight(){
		return right;
	}		

	// SET METHODS
	public void setData(Integer val){
		data = val;
	}

	public void setLeft(TreeNode leftnode){
		left = leftnode;
	}

	public void setRight(TreeNode rightnode){
		right = rightnode;
	}

}