public class TreeNodeInteger{

   // Instance variables
   private Integer data;
   private TreeNodeInteger left;
   private TreeNodeInteger right;
   
   // Default constructor
   public TreeNodeInteger(Integer val){
      data = val;
      left = null;
      right = null;    
   }
   
   // Constructor with arguments
   public TreeNodeInteger(Integer val, TreeNodeInteger leftnode, TreeNodeInteger rightnode){
      data = val;
      left = leftnode;
      right = rightnode; 
   }
   
   // GET METHODS
	public Integer getData(){
		return data;
	}

	public TreeNodeInteger getLeft(){
		return left;
	}
	
	public TreeNodeInteger getRight(){
		return right;
	}		

	// SET METHODS
	public void setData(Integer val){
		data = val;
	}

	public void setLeft(TreeNodeInteger leftnode){
		left = leftnode;
	}

	public void setRight(TreeNodeInteger rightnode){
		right = rightnode;
	}
   
}