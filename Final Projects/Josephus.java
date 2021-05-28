// Torbert, 11.16.2004
// version 2 by M. Billington, 10.28.2005
// version 3 by T. Rudwick, 11.17.2015
// version 4 for Grade-It, mlbillington, 6.24.2017

import java.util.*;
import java.io.*;
import javax.swing.JOptionPane; 

public class Josephus
{
   static class ListNode{
      public String name;       
      public ListNode next;  
   
      public ListNode() {
         this("", null);
      }
   
      public ListNode(String n) {
         this(n, null);
      }
   
      public ListNode(String n, ListNode next) {
         this.name = n;
         this.next = next;
      }
      
      public String getValue(){
         return name;
      }
      
      public void setNext(ListNode n){
         next = n;
      }
      
      public ListNode getNext(){
         return next;
      }
      
      public void setValue(String n){
         name = n;
      }
   }
   private static String WINNER = "Josephus";

   public static void main(String[] args) throws FileNotFoundException
   {           
      // Get user inputs
      Scanner sc = new Scanner(System.in);
      System.out.print("How many names (2-20)? ");
      int n = Integer.parseInt(sc.next());
      System.out.print("How many names to count off each time? ");      
      int countOff = Integer.parseInt(sc.next());
      System.out.print("Where should "+WINNER+" stand?  ");
      int winPos = Integer.parseInt(sc.next());  
      
      // Run the Josephus circle algorithm and print the result
      ListNode theWinner = josephusCircle(n, countOff, winPos);
      System.out.println(theWinner.getValue() + " wins!");  
   }
   
   public static ListNode josephusCircle(int n, int countOff, int winPos)
   {
      ListNode p = null;
      p = makeNameLinkedList(n);
      replaceAt(p, WINNER, winPos);
      p = countingOff(p, countOff, n);
      return p;
   }
   
   
   /* Make LinkedList of names
     */
   public static ListNode makeNameLinkedList(int n)
   {
      String[] name_strings = {"Michael", "Hannah", "Jacob", "Ruth", "Matthew", "Elizabeth", "Josiah", "Jesse", "Elisha", "Sarah", "Elijah", "David", "Israel", "Leah", "Meshach", "Abednego", "Joshua", "Rebecca", "Daniel", "Eleazar"}; 
      int count = 0;
      ListNode p=null;
      while(count < n && count < name_strings.length)
      {
         p = insert(p, name_strings[count]);
         count++;
      }
      return p;
   }
   
    /* helper method to build the list.  Instantiates the node, then
    inserts it in the circular linked list.
    */
   public static ListNode insert(ListNode p, String obj)
   {
      ListNode temp = new ListNode(obj, null);
      if(p == null)
      {
         temp.setNext(temp);
         return temp;
      }
      else
      {
         temp.setNext(p.getNext());
         p.setNext(temp);
         return temp;
      }
   }
   
   
  /* Runs a Josephus game, counting off and removing each name. Prints after each removal.
     Ends with one remaining ListNode, which contains the winner. 
     */
   public static ListNode countingOff(ListNode p, int count, int n)
   {
      /* YOUR CODE HERE */
      return remove(p, count, n);
   }
   
   
   /* removes the node after counting count-1 nodes.
     */
   public static ListNode remove(ListNode p, int count, int n)
   {
      /* YOUR CODE HERE */
      
      ListNode head = p;
      print(p);
      for(int i = 0; i < n - 1; i++){
         for(int x = 0; x < count - 1; x++)
         {
            head = head.getNext();
         }
         if(head.getNext() == p)
         {
            ListNode node = head.getNext().getNext();
            head.setNext(node);
            p = head;
            print(head);
         }
         else
         {
            ListNode node = head.getNext().getNext();
            head.setNext(node);
            print(head);
         }  
      }
      return head;
   }
   
  
   /* prints the circular linked list.
     */
   public static void print(ListNode p)
   {
      /* YOUR CODE HERE */
      if(p == null)
      {
         return;
      }
      else
      {
         ListNode node = p.getNext();
         while(node != p)
         {
            System.out.print(node.getValue() + " ");
            node = node.getNext();
         }
         System.out.println(node.getValue() + "");
      }	
   }

   /* replaces the value (the name) at the winning node.
      */
   public static void replaceAt(ListNode p, String obj, int pos)
   {
      /* YOUR CODE HERE */
      ListNode node = p;
      for(int x = 0; x < pos; x++)
      {
         node = node.getNext();
      }
      node.setValue(obj);
      p = node;   
   }
   
  
   
}
