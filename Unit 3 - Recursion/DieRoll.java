
public class DieRoll{
   public static void main(String[]args){
   ////////////// ITERATIVE DIE ROLLING ///////////////////////////
   
      int[] array = {1,2,3,4,5,6};
      int i,j;
      for(i = 0; i<array.length; i++){
         for(j = 0; j<array.length; j++){
            System.out.print("("+array[i]+","+array[j]+")"); 
         }
         System.out.println("");
      }
   }

}