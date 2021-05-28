
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IsPalindromeMethod{

   public static void main(String[] args){ 
      
      Queue<Integer> q = new LinkedList<Integer>();
      
      /* ODD PALINDROME */
      q.add(4);
      q.add(8);
      q.add(17);
      q.add(9);
      q.add(17);
      q.add(8);
      q.add(3);  
            
      /* EVEN PALINDROME */
      /*
      q.add(2);
      q.add(4);
      q.add(6);
      q.add(6);
      q.add(4);
      q.add(2);  
      */
      
      // Print the queue before the palindrome check
      System.out.println(q);
      
      // Run the palindrome check
      System.out.println(isPalindrome(q));
      
      // Print the queue after the check
      System.out.println(q);
   
   }
   
   public static boolean isPalindrome(Queue<Integer> q){
      
      // Create a stack for storage
      Stack<Integer> s = new Stack<Integer>();
      
      // Check the queue
      int q_size = q.size(); 
      boolean iseven = (q_size % 2 == 0); 
      
      // If the queue is empty, it's a palindrome
      if(q_size == 0){
         return true;
      }
      
      // Process non-empty queues
      boolean is_palindrome = true;
      Integer temp1, temp2;
      if(iseven){
         
         /********* EVEN QUEUE SIZE *********/
         
         // Push the first n/2 elements onto the stack
         int i;
         for(i = 0; i < q_size/2; i++){
            temp1 = q.remove();
            s.push(temp1);
            q.add(temp1);            
         }
         
         // For the remaining n/2 elements of the queue, compare the queue to the stack contents
         for(i = q_size/2; i < q_size; i++){
            temp1 = q.remove();
            temp2 = s.pop();
            if(temp1 != temp2){
               is_palindrome = false;
            }
            q.add(temp1);  
         }
      
      } else {
      
         /********* ODD QUEUE SIZE *********/
         
         // Push the first n/2 elements onto the stack
         int i;
         for(i = 0; i < q_size/2; i++){
            temp1 = q.remove();
            s.push(temp1);
            q.add(temp1);            
         }
         
         // For the middle element, it is already "matched", so just put it back on the queue at the end
         temp1 = q.remove();
         q.add(temp1);           
         
         // For the remaining n/2 elements of the queue, compare the queue to the stack contents
         for(i = (q_size/2+1); i < q_size; i++){
            temp1 = q.remove();
            temp2 = s.pop();
            if(temp1 != temp2){
               is_palindrome = false;
            }
            q.add(temp1);  
         }
      
      }
         
      return is_palindrome;     
   }
  
}

