import java.util.LinkedList; 

public class IntQueueJava{
   
   // Instance variables 
   LinkedList<Integer> qlist;  // The queue is actually a linked list  
   
   // Constructor
   public IntQueueJava(){
      // Create the list
      qlist = new LinkedList<Integer>();  
   }
     
   public boolean add(int num){
      qlist.addLast(num);
      return true; 
   }
   
   public int remove(){
      return qlist.removeFirst();  
   }
   
   public int poll(){
      return qlist.removeFirst();  
   }
   
   public int peek(){
      return qlist.peekFirst();
   }

   public int size(){
      return qlist.size();  
   }

}



//************** TEST CODE ***************** //


