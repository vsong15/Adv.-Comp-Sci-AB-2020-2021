
import java.util.LinkedList;

public class StringHashTableChaining{

   private LinkedList[] hashtable;
   private int size; 

   public StringHashTableChaining(){
      hashtable = new LinkedList[11];
      size = 11;   
   }
   
   public StringHashTableChaining(int number_of_keys){
      
      // Calculate the most appropriate table size
      double k_decimal = number_of_keys/0.75;
      int k = (int)(k_decimal); 
      int closest_prime = PrimeNumberCalculator.closetPrime(k);
      int num_entries = closest_prime;
      
      // Create the table
      hashtable = new LinkedList[num_entries];
            
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
      LinkedList<String> templist;
      if(hashtable[table_index] == null){
         // If there is no linked list, create one
         templist = new LinkedList<String>();
      } else {
         // Retrieve the existing list
         templist = hashtable[table_index];
      }
      
      // Add the key to the linked list
      templist.add(key); 
      hashtable[table_index] = templist;
         
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