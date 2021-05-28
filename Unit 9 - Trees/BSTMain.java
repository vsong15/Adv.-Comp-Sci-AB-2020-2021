
public class BSTMain{

   public static void main(String[] args){
            
      // Declare a BST
      BinarySearchTree tree = new BinarySearchTree();
      
      // Insert numbers into the tree
      tree.insert(6);
      tree.insert(2);
      tree.insert(4);
      tree.insert(1);
      tree.insert(8);
      tree.insert(3);
      tree.insert(5);
      
      // Print the post-order traversal of the tree
      tree.printPostOrder(); 
      
      // Count the left nodes
      tree.printTreeLeaves(); 
            
   }


}