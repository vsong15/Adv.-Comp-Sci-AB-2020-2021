public class Test_QueueJava{

   public static void main(String[] args){  
      
      // Create the queue
      IntQueueJava q = new IntQueueJava();
      
      // Add numbers to the queue
      q.add(1);
      q.add(3);
      q.add(5);
      q.add(7); 
      
      // Print the contents of the queue in order
      while(q.size() != 0){
         System.out.println(q.remove() + " " + q.size());  
      }
   
   }

}