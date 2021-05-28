public class IntegerLinkedList{
   public static void main(String[]args){
      IntegerListNode n1 = new IntegerListNode(100);
      IntegerListNode n2 = new IntegerListNode(200);
      IntegerListNode n3 = new IntegerListNode(300);
      IntegerListNode n4 = new IntegerListNode(400);
      IntegerListNode n5 = new IntegerListNode(500);
         
      IntegerListNode head = n1;
      n1.setNext(n2);
      n2.setNext(n3);
      n3.setNext(n4);
      n4.setNext(n5);
      
      addIntList(head);
   }
   
   public static void addIntList(IntegerListNode head){
      int count = 0;
      IntegerListNode ref = head;
      while(ref != null){
         count += ref.getData();
         ref = ref.getNext();
      }
      System.out.println(count);
   }
}