
public class BSTMain{

   public static void main(String[] args){
      
      BinarySearchTree tree = new BinarySearchTree();
      
      // Number set 1
      /*
      tree.insert(4);
      tree.insert(3);
      tree.insert(5);
      tree.insert(4);
      tree.insert(4);
      tree.insert(7);
      */
      
      // Number set 2
      tree.insert(4);
      tree.insert(10);
      tree.insert(6);
      tree.insert(3);
      tree.insert(12);
      tree.insert(5);
      tree.insert(11);
      tree.insert(9);
      tree.insert(1);      
      
      tree.printPostOrder();
      
      TreeNode temp = tree.find(3);
      
      if(temp != null){
         System.out.println(temp.getData());  
      } else {
         System.out.println("Could not find the value");
      }
      
      System.out.println("Number of nodes in the tree: " + tree.countNodes()); 
         
   }

}