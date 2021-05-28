public class IntegerLinkedList{
   public static void main(String[]args){
      IntegerListNode i1 = new IntegerListNode(100);
      IntegerListNode i2 = new IntegerListNode(200);
      IntegerListNode i3 = new IntegerListNode(300);
      IntegerListNode i4 = new IntegerListNode(400);
      IntegerListNode i5 = new IntegerListNode(500);
         
      IntegerListNode head = i1;
      i1.setNext(i2);
      i2.setNext(i3);
      i3.setNext(i4);
      i4.setNext(i5);
      
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