public class StringArrayList{
   
      // Class variables
      private int size;
      private String[] stringarray;
         
      // Default constructor
      public StringArrayList(){
         size = 0;
         stringarray = new String[5];     
      }   
      
      ////////////// size()
      public int size(){
         return size;
      }
      
      ////////////// get(int index)
      public String get(int index){
      
         // Your code for the get() method will go here.
         // The method will return the String object stored at the specified index.
         // Make sure that you include code to check to see whether the index is within bounds
         // (i.e. make sure it is greater than 0 and not outside of the set of occupied array elements)
         String ans = "";
         if(index > 0 && index < stringarray.length)
            ans = stringarray[index];
         return ans;
      }
      
      ///////////////// set(int index)
      public void set(int index, String str){
         
         // Your code for the set() method will go here.
         // The method will take the String str and place it at the location specified by index.
         // Make sure that you include code to check to see whether the index is within bounds
         // (i.e. make sure it is greater than 0 and not outside of the set of occupied array elements)
         if(index > 0 && index < stringarray.length)
            stringarray[index] = str;
      }
         
      /////////////////// add(String str) 
      public void add(String str){
         
         // Your code for the [first] add() method will go here.
         // The method will take the String str and place it at the end of the array.
         // Your method will need to increase the size of the internal array where needed 
         // since the ArrayList needs to appear "flexible" to the user.    
         // Also, make sure that your method updates the size variable.  
         if(size >= stringarray.length){ 
            String[]temp = new String[stringarray.length + 1];
            for (int i = 0; i < stringarray.length; i++){
               temp[i] = stringarray[i];
            }
            stringarray = temp;         
         }    
         for(int i = 0; i < stringarray.length; i++){
            if(stringarray[i] == null){
               stringarray[i] = str;      
               break;
            }
         }
         size++;
      }
      
      ////////////////// add(int index, String str)
      public void add(int index, String str){
      
         // Your code for the [second] add() method will go here.
         // The method will take the String str and place it at the place in the array specified
         // by index, then shift the remaining array elements to the right.  
         // Your method will need to increase the size of the internal array where needed 
         // since the ArrayList needs to appear "flexible" to the user.    
         // Also, make sure that your method updates the size variable. 
         int count = 0;
      
         if(size + 1> stringarray.length){ 
            String[]temp = new String[stringarray.length + 1];
            for (int i = 0; i < stringarray.length; i++){
               temp[i] = stringarray[i];
            }
            stringarray = temp;         
         }    
         String[] newstringarray = new String[stringarray.length];
      
         for(int i = 0; i < index; i++){
            newstringarray[i] = stringarray[i];
            count++;
         }   
         newstringarray[index] = str;
         System.arraycopy(stringarray, index, newstringarray, index + 1, (size + 1) - count - 1);
         stringarray = newstringarray;
         size++;
      }
      
      //////////////////////// remove(int index)   
      public void remove(int index){
      
         // Your code for the [second] add() method will go here.
         // The method will remove the item stored at the location specified by index, then
         // shift the items that were to the right of the index to the left by one.
         // Also, make sure that your method updates the size variable.   
         String[] newstringarray = new String[stringarray.length];
         for(int i = 0; i < index; i++)
            newstringarray[i] = stringarray[i];
         System.arraycopy(stringarray, index + 1, newstringarray, index, stringarray.length - (index + 1));
         size--;
         stringarray = newstringarray;
      }
     
      //////////////////////// toString() method
      public String toString(){
         String output = "";
         for(int i = 0; i<(size); i++){
            if(i == (size-1))
               output = output + stringarray[i];
            else
               output = output + stringarray[i] + ", ";
         }
         return output;
      }
      
      
   }