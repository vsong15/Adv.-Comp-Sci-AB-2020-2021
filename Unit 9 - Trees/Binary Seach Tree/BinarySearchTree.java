
/* NOTE:  Code adapted from Barron’s AP Computer Science 
Levels A and AB, 4th Edition, 2008 */

public class BinarySearchTree{

	private TreeNode root;

	// Default Constructor
	public BinarySearchTree(){
		root = null;
	}

	// Constructor with arguments
	public BinarySearchTree(TreeNode node){
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
	public void insert(Integer data){
   
      // Create a new node with the data inside
      TreeNode tempnode = new TreeNode(data);  
   
      // If the root is empty, make a new node & make it the root
      if(root == null){
         root = tempnode;      
         return;
      }
		
      // Search for the correct place to insert the node
      TreeNode a,b;
      a = root;
      b = null;
      while(a != null){
      
         b = a;
      
         // Determine whether to go left or right
         if(data < a.getData()){
            // Go left
            a = a.getLeft();   
         } else {
            // Go right
            a = a.getRight();
         } 
      }
      
      // Insert the node into the tree
      if(data < b.getData()){
         // Insert it at the left
         b.setLeft(tempnode);
      } else {
         // Insert it to the right
         b.setRight(tempnode);
      }
      
	}
   
   // Find a node in a tree
   public TreeNode find(Integer data){
      
      TreeNode t = root;
      
      while((t != null) && (t.getData() != data)){
         if(data < t.getData())
            t = t.getLeft();
         else
            t = t.getRight();       
      }
      
      return t;  
  
   }
   
   // Print the nodes using post-order traversal   
   public void printPostOrder(){
      searchPostOrder(root);  
      System.out.println();
   }
   
   public void searchPostOrder(TreeNode t){
      
      if(t != null){
         searchPostOrder(t.getLeft());
         searchPostOrder(t.getRight());
         System.out.print(t.getData() + " ");      
      }
   
   }
   
   // Count the nodes using post-order traversal 
   public int countNodes(){
   
      return countPostOrder(root);  
      
   }
   
   public int countPostOrder(TreeNode t){
      
      if(t != null){
         return 1 + countPostOrder(t.getLeft()) + countPostOrder(t.getRight());
      } else {
         return 0;
      }
      
   }

}
