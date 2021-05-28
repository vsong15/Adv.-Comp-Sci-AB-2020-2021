
public class IntStackJava{

   private int[] stackarray;  
   private int size; 
   
   public IntStackJava(){
      stackarray = new int[10];
      size = 0;
   }
   
   public IntStackJava(int capacity){
      stackarray = new int[capacity];
      size = 0;         
   }
   
   public boolean empty(){
      if(size == 0)
         return true;
      else
         return false;     
   }
   
   public int peek(){
      return stackarray[size-1];  
   }
   
   public int pop(){
      size--;
      return stackarray[size];
   }
   
   public boolean push(int num){
   
      if(size <= stackarray.length){
         size++;
         stackarray[size-1] = num; 
         return true;  
      } else {
         return false;
      }
   
   }
   
}


//************** TEST CODE ***************** //

