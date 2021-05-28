import java.util.ArrayList;
public class HelloWorld{
   public static void main(String []args){
      int[] arr = new int[9];
      for(int i = 0; i < arr.length; i++){
         arr[i] = i;
             
      }
      int[] array = filterArray(arr);
      for(int i = 0; i < array.length; i++){
         System.out.println(array[i]);
             
      }
   }
   public static int[] filterArray(int[] arr){
   
      int count = 0;
      for(int i = 0; i < arr.length; i++){
         if(arr[i] % 2 == 0){
            count++;
         } 
      }     
   
      int[] filtered = new int[count];
   
      count = 0; 
      for(int i = 0; i < arr.length; i++){
         if(arr[i] % 2 == 0){
            filtered[count] = arr[i];
            count++;
         } 
      }    
   
      return filtered;       
   }

   public static ArrayList<Integer> filterArrayList(ArrayList<Integer> arr){
   
      ArrayList<Integer> filtered = new ArrayList<Integer>();
      for(int i = 0; i < arr.size(); i++){
         if(arr.get(i) % 2 == 0){
            filtered.add(arr.get(i));
         } 
      }    
   
      return filtered;    
   
   }

}