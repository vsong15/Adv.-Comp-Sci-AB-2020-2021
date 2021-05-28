import java.util.*;

public class BinarySearchTreeInteger{

   // Instance variables
   private TreeNodeInteger root;  
   
   // Default Constructor
   public BinarySearchTreeInteger(){
      root = null;
   }

	// Constructor with arguments
   public BinarySearchTreeInteger(TreeNodeInteger node){
      root = node;
   }

	// SET & GET METHODS
   public TreeNodeInteger getRoot(){
      return root;
   }
   
   // Set the root 	
   public void setRoot(TreeNodeInteger node){
      root = node;
   }
   
   
  // Insert method (for adding numbers to the tree)
   public void insert(Integer data){
   
      TreeNodeInteger tempnode = new TreeNodeInteger(data);  
   
      // If the tree is empty, add the node to the root
      if(root == null){
         root = tempnode;
         return;
      }
   
      // Search the tree for the place to put the new node
      TreeNodeInteger a = root; 
      TreeNodeInteger b = null;
      while(a != null){
      
         b = a;  
         if(data < a.getData()){
            a = a.getLeft();  
         } else {
            a = a.getRight(); 
         }
      
      }
   
      // Insert the node at the correct place
      if(data < b.getData()){
         b.setLeft(tempnode);  
      } else {
         b.setRight(tempnode);
      }
   
   }
  
   // Print the nodes using post-order traversal
   public void printPostOrder(){
      searchPostOrder(root);
      System.out.println();  
   }
  
   // Print nodes using post-order traversal
   public void searchPostOrder(TreeNodeInteger t){
   
      if(t != null){
         searchPostOrder(t.getLeft());
         searchPostOrder(t.getRight());
         System.out.print(t.getData() + " ");
      }
   
   }
   
   // Find method 
   public TreeNodeInteger find(Integer data){
      
      TreeNodeInteger t = root;
      
      while((t.getData() != data) && (t != null)){
         if(data < t.getData()){
            t = t.getLeft();
            System.out.println("LEFT-");
         } else {
            t = t.getRight(); 
            System.out.println("RIGHT-");
         }
      }
      
      return t;  
   }
   
   // Count the nodes post-order
   public int countNodes(){
      return countPostOrder(root);  
   }
   
   // Count the nodes in the tree
   public int countPostOrder(TreeNodeInteger t){
      
      if(t != null){
         return 1 + countPostOrder(t.getLeft()) + countPostOrder(t.getRight());
      } else {
         return 0;  
      }
   }
   
   
   /* ************** Find the max value in a tree **************** */
   public int getMaxValue(){
      return findMax(root);
   }
   
   public int findMax(TreeNodeInteger t){
      
      /* YOUR CODE HERE */ 
      if(t == null)
         return Integer.MIN_VALUE;
      int max = t.getData();
      int left_max = findMax(t.getLeft());
      int right_max = findMax(t.getRight());
      if(left_max > max)
         max = left_max;
      if(right_max > max)
         max = right_max;
      return max;
   }
   
   
   /* ************** Determine the height of the tree **************** */
   public int getTreeHeight(){
      return height(root);
   }
   
   public int height(TreeNodeInteger t){
      
     /* YOUR CODE HERE */  
      if(t == null)
         return 0;
      Queue<TreeNodeInteger> q = new LinkedList<TreeNodeInteger>();
      q.add(t);
      int height = 0;
      while(true){
         int node_count = q.size();
         if(node_count == 0)
            return height;
         height++;
         while(node_count > 0){
            TreeNodeInteger new_node = q.peek();
            q.remove();
            if(new_node.getLeft() != null)
               q.add(new_node.getLeft());
            if(new_node.getRight() != null)
               q.add(new_node.getRight());
            node_count--;
         }
      }
   }
   
   
    
   
   /* ************** Count the empty nodes in a tree **************** */
   
   // Count the empty nodes
   public int countEmptyBranches(){
      return countEmpty(root);      
   }
   
   public int countEmpty(TreeNodeInteger t){
   
      /* YOUR CODE HERE */  
      return 0;
   }

   
   /* ************** Count the empty nodes in a tree **************** */
   
   
   // Check to see if a binary is tree is full
   public boolean isTreeFull(){
      return isFull(root);
   }
   
   public boolean isFull(TreeNodeInteger t){
   
    /* YOUR CODE HERE */
      return false;
   }   
   
   
   
   /* ************** Print the leaves in a tree **************** */
   public void printTreeLeaves(){
      printLeaves(root);
   }
   
   public void printLeaves(TreeNodeInteger t){
   
   /* YOUR CODE HERE */
      if(t == null){
         return;
      }
      if(t.getLeft() == null && t.getRight() == null){
         System.out.print(t.getData() + " ");
         return;
      }   
      if(t.getRight() != null){
         printLeaves(t.getRight());
      }
      if(t.getLeft() != null){
         printLeaves(t.getLeft());
      }
   }   
   
}


