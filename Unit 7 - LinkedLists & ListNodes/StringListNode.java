public class StringListNode{
// Instance variables
   private String data;
   private StringListNode next;
//---------- Constructors
   public StringListNode(){
      data = null;
      next = null;
   }
   public StringListNode(String str){
      data = str;
      next = null;
   }
   public StringListNode(String str, StringListNode noderef){
      data = str;
      next = noderef;
   }
//---------- Methods
   public void setData(String str){
      data = str;
   }
   public String getData(){
      return data;
   }
   public void setNext(StringListNode noderef){
      next = noderef;
   }
   public StringListNode getNext(){
      return next;
   }
}