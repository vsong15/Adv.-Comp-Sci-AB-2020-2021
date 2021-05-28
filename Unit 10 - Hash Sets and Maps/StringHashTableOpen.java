

public class StringHashTableOpen{

   private String[] hashtable;
   private int size; 

   public StringHashTableOpen(){
      hashtable = new String[11];
      size = 11;   
   }
   
   public StringHashTableOpen(int number_of_keys){
      
      // Calculate the most appropriate table size
      double k_decimal = number_of_keys/0.75;
      int k = (int)(k_decimal); 
      int closest_prime = PrimeNumberCalculator.closetPrime(k);
      int num_entries = closest_prime;
      
      // Create the table
      hashtable = new String[num_entries];
            
      // Update the table size  
      size = num_entries;  
      
      // Print the size
      System.out.println("Hash table with " + num_entries + " entries created.");
   
   }
   
   // Add an entry to the table
   public void addKey(String key){
   
      // Calculate the table index
      int table_index  = calculateTableIndex(key);
      
      // Add the entry to the table
      if(hashtable[table_index] == null){
      
         // If the table is available at that point, insert the key there
         hashtable[table_index] = key;
         
      } else {
      
         // Insert the key at the next available spot
         while(hashtable[table_index] != null){
            table_index++;
            if(table_index >= size){
               // If we get to the end of the table, wrap-around
               table_index = 0;
            }
         }
         hashtable[table_index] = key;
         
      }
         
   }
   
   // Calculate the table index from this key
   public int calculateTableIndex(String key){
   
      // Calculate the hash code
      int hash_code = key.hashCode();  
      hash_code = Math.abs(hash_code);      
      
      // Calculate the table index
      int table_index = hash_code % this.size;
   
      return table_index;  
   }
   
   
   // Print the table contents
   public void printTable(){
      
      for(int i = 0; i < size; i++){
         System.out.println(i + " = " + hashtable[i]);
      }
   
   }
   

}