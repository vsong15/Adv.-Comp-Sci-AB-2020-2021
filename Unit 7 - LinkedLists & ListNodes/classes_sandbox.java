import java.util.Scanner;
import java.util.*;
public class classes_sandbox{
   public static void main(String[] args){
   // Create list nodes with values inside
      StringListNode n1 = new StringListNode("Bills");
      StringListNode n2 = new StringListNode("Eagles");
      StringListNode n3 = new StringListNode("Cheifs");
      StringListNode n4 = new StringListNode("Wash");
   // Link the nodes together
      StringListNode head = n1;
      n1.setNext(n2);
      n2.setNext(n3);
      n3.setNext(n4);
   // Print the list
      printStringList(head);
   // Add a string to the end of the list
      addToEnd(head,"Pats");
   // Print the list
      printStringList(head);
   // Add a string to the front of the list
      head = addToFront(head,"Seahawks");
   // Print the list
      printStringList(head);
   // Remove a string from the list
      head = remove(head,"Seahawks");
   // Print the list
      printStringList(head);
   }
// Print the list
   public static void printStringList(StringListNode head){
      StringListNode ref = head;
      System.out.print("[");
      while(ref != null){
         System.out.print(ref.getData() + " ");
         ref = ref.getNext();
      }
      System.out.print("]");
      System.out.println("");
   }
// Add a node to the end of the list
   public static void addToEnd(StringListNode head, String str){
      StringListNode newnode = new StringListNode(str);
      StringListNode ref = head;
      StringListNode prior = null;
      while(ref != null){
         prior = ref;
         ref = ref.getNext();
      }
      prior.setNext(newnode);
   }
// Add a node to the front of the list
   public static StringListNode addToFront(StringListNode head, String str){
      StringListNode newnode = new StringListNode(str);
      newnode.setNext(head);
      head = newnode;
      return head;
   }
// Remove an item from the list
   public static StringListNode remove(StringListNode head, String str){
      StringListNode ref = head;
      StringListNode prior = head;
   // Search for the matching node
      while(ref != null){
         if(ref.getData().equals(str)){
         // Remove the matching node
            if(prior == head){
               head = ref.getNext();
            } else {
               prior.setNext(ref.getNext());
               break;
            }
         }
         prior = ref;
         ref = ref.getNext();
      }
      return head;
   }

}