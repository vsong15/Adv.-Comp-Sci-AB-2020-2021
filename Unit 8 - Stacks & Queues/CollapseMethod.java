
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CollapseMethod{

   public static void main(String[] args){ 
      
      Stack<Integer> s = new Stack<Integer>();
      
      /* TEST 1 */
      /*
      for(int i = 1; i <= 5; i++){
         s.push(i);
      }
      */
      
      /* TEST 2 */
      s.push(7);
      s.push(2);
      s.push(8);
      s.push(9);
      s.push(4);
      s.push(13);
      s.push(7);
      s.push(1);
      s.push(9);
      s.push(10);
                  
      // Print the stack before
      System.out.println(s);
   
      // Collapse the stack
      collapse(s);
      
      // Print the stack after
      System.out.println(s);
   
   }
   
   public static void collapse(Stack<Integer> s){
   
      // Exit if the stack is empty
      if(s.empty()){
         return;
      }  
   
      // Create a queue for storage
      Queue<Integer> q = new LinkedList<Integer>();
      
      // Check the size of the stack
      int s_size = s.size();
      boolean is_even = (s_size % 2 == 0);
      
            
      //--------- Combine values in the stack and put them into a queue  -----//
      
      // For an odd number of values in the stack, pop the first value
      if(!is_even){
         q.add(s.pop()); 
      }              
      
      // Combine the values in the stack two at a time and put them into the queue
      while(!s.empty()){
         q.add(s.pop() + s.pop());      
      }
      
      // Push the values from the queue into the stack
      while(q.peek() != null){
         s.push(q.remove());
      }
  
        
      //-------- Reverse the order of the stack -------//
            
      // Put the stuff in the stack into the queue
      while(!s.empty()){
         q.add(s.pop());
      }
      
      // Put the stuff in the queue into the stack
      while(q.peek() != null){
         s.push(q.remove());
      }

   }
  
  
}
