public class TestStackJava{
   
   public static void main(String[] args){  
   
      IntStackJava s = new IntStackJava();
      
      s.push(4);
      s.push(5);
      s.push(6);
      s.push(7); 
      
      while(!s.empty()){
         System.out.println(s.pop());              
      }   

   }

}