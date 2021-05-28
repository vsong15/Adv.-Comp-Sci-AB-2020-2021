public class IntegerListNode{
// Instance variables
   private Integer data;
   private IntegerListNode next;
//---------- Constructors
   public IntegerListNode(){
      data = null;
      next = null;
   }
   public IntegerListNode(Integer num){
      data = num;
      next = null;
   }
   public IntegerListNode(Integer num, IntegerListNode noderef){
      data = num;
      next = noderef;
   }
//---------- Methods
   public void setData(Integer num){
      data = num;
   }
   public Integer getData(){
      return data;
   }
   public void setNext(IntegerListNode noderef){
      next = noderef;
   }
   public IntegerListNode getNext(){
      return next;
   }
}