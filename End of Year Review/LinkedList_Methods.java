
// Created by D. Murray
// Updated by T. Troast 4/29/2021

public class LinkedList_Methods{

   public static void main(String[] args){
   
      ListNode<Integer> head = null;
         
      int[] arr = {3, 3, 9, 4, 2, 3, 3, 8, 17, 4, 3, 18, 3}; 
   
      head = addToList(head,arr);           
         
      showList(head);  
         
      head = removeAll(head,3);  
         
      showList(head); 
   }
   
   public static void showList(ListNode h)
   {
      for(ListNode start=h;start!=null;start=start.getNext())
         System.out.print(start.getValue()+" ");
      System.out.println();
   }
   
   public static ListNode addToList(ListNode head, int[] arr){
      head = new ListNode(arr[arr.length-1],null);
      for(int i = arr.length-2; i >= 0; i--){
         head = new ListNode(arr[i],head);  
      }
      return head;   
   }
   
   public static ListNode stutter(ListNode head){
      
      int x;
      ListNode temp;
      ListNode pointer; 
      ListNode after;
      
      pointer = head;    
      while(pointer != null){      
         after = pointer.getNext();  
         temp = new ListNode(pointer.getValue(),after);  
         pointer.setNext(temp);
         pointer = after;  
      }
      
      return head;  
         
   }
   
   public static ListNode removeAll(ListNode head, int num){
   
      ListNode pointer; 
      ListNode previous; 
      
      // Skip over matches at the front of the linked list
      while(head.getValue().equals(num)){
         head = head.getNext();
      }  
      
      // Remove remaining matches from the list
      pointer = head;
      previous = head;
      while(pointer != null){     
         if(pointer.getValue().equals(num)){
            previous.setNext(pointer.getNext());  
         } else {
            previous = pointer;
         }
         pointer = pointer.getNext(); 
      }
      
      return head;  
   }

}
