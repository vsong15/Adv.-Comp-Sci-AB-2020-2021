public class RecursiveCombinations{

   public static void main(String[] args){
      int N_DIGITS = 3;
      int[] arr = {1,2,3};
      recursivePrintHelper(N_DIGITS,arr);
      //int[] storage = new int[N_DIGITS];
      //recursivePrint(arr,storage,N_DIGITS,0);
   }
   
   static void recursivePrintHelper(int num_digits, int[] array){
      int[] storage = new int[num_digits];
      recursivePrint(array,storage,num_digits,0);
   }
   
   static void recursivePrint(int[] array,int[] storage, int num_digits,int index){
      if(num_digits == 0){
         int j;
         for(j = 0; j<storage.length; j++){
            System.out.print(storage[j] + " ");
         }
         System.out.println("");
         return;
      }
      else{
         int i;
         for(i = 0; i<array.length; i++){
            storage[index] = array[i];
            recursivePrint(array,storage,num_digits-1,index+1);  
         }
      }
   }
      
      
}
