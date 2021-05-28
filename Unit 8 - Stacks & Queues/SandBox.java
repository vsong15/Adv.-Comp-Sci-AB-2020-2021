import java.util.*;
public class SandBox{
   public static void main(String[]args){
      Stack<Integer> s1 = new Stack<Integer>();
      
      s1.push(3);
      s1.push(7);
      s1.push(1);
      s1.push(14);
      s1.push(9);
      System.out.println(s1);
      System.out.println(stutter(s1));
      System.out.println(s1);
   }
   public static Stack<Integer> stutter(Stack<Integer> s){
         /* your code here */ 
      Queue<Integer> q = new LinkedList<Integer>();
      int temp = 0;
      while(!s.empty()){
         temp = s.pop();
         q.add(temp);
         q.add(temp);
      }
      while(q.peek() != null){
         s.push(q.poll());
      }
      while(!s.empty()){
         q.add(s.pop());
      }
      while(q.peek() != null){
         s.push(q.poll());
      }
     
      return s;
   }
         /*
   public static Stack<Integer> copyStack(Stack<Integer> s){
      Stack<Integer> new_stack = new Stack<Integer>();
      Queue<Integer> q = new LinkedList<Integer>();
      while(!s.empty()){
         q.add(s.pop());
      }
      while(q.peek() != null){
         new_stack.push(q.poll());
      }
      while(!new_stack.empty()){
         q.add(new_stack.pop());
      }
      int temp = 0;
      while(q.peek() != null){
         temp = q.poll();
         new_stack.push(temp);
         s.push(temp);
      }
      return new_stack;
   }
   */
}
