

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SplitStackMethod{

   public static void main(String[] args){ 
      
      Stack<Integer> s = new Stack<Integer>();
   
      s.push(-2);
      s.push(1);
      s.push(3);
      s.push(-4);
   
      // Print the stack before the method
      System.out.println(s);
   
      // Call the method
      splitStack(s);
      
      // Print the stack after the method call
      System.out.println(s);
   
   }
   
   public static void splitStack(Stack<Integer> s){
   
      // Create a queue for storage
      Queue<Integer> q = new LinkedList<Integer>();
      
      // Pop everything from the stack and put it into the queue
      while(!s.empty()){
         q.add(s.pop());
      }      
      
      // Go through the queue - negative numbers should be pushed onto the stack
      int q_size = q.size();
      Integer temp;
      for(int i = 0; i < q_size; i++){
         temp = q.remove();
         if(temp < 0){
            s.push(temp);
         } else {
            q.add(temp);
         }
      }
   
      // Push all remaining items from the queue onto the stack
      while(q.peek() != null){
         temp = q.remove();
         s.push(temp);
      } 
   
   }
      
      
  
}
