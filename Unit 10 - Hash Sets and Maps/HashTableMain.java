

public class HashTableMain{

   public static void main(String[] args){
     
     
      ////////////////////// CITIES ///////////////////////////
     
      /*
     
      // ***********  Open addressing 
     
      // Create the hash table
      StringHashTableOpen ht = new StringHashTableOpen(5);  
     
      // Add the keys
      ht.addKey("Franconia");
      ht.addKey("Springfield");
      ht.addKey("Alexandria");
      ht.addKey("Arlington");
      ht.addKey("Woodbridge");
   
      // Print the table
      ht.printTable();  
      
     
   
      // ***********  Chaining 
   
      // Create the hash table
      StringHashTableChaining ht = new StringHashTableChaining(5); 
   
      ht.addKey("Franconia");
      ht.addKey("Springfield");
      ht.addKey("Alexandria");
      ht.addKey("Arlington");
      ht.addKey("Woodbridge");
   
      // Print the table
      ht.printTable();  
      
   
      ///////////////// HOCKEY TEAMS ///////////////////////////
   
      // ***********  Open addressing 
         
      // Create the hash table
      StringHashTableOpen ht = new StringHashTableOpen(6);  
     
      // Add the keys
      ht.addKey("Capitals");
      ht.addKey("Islanders");
      ht.addKey("Penguins");
      ht.addKey("Bruins");
      ht.addKey("Flyers");
      ht.addKey("Rangers");
   
      // Print the table
      ht.printTable();         
      
       */

     
      // ***********  Chaining 
     
      // Create the hash table
      StringHashTableChaining ht = new StringHashTableChaining(6);  
   
      // Add the keys
      ht.addKey("Capitals");
      ht.addKey("Islanders");
      ht.addKey("Penguins");
      ht.addKey("Bruins");
      ht.addKey("Flyers");
      ht.addKey("Rangers");
   
      // Print the table
      ht.printTable();  
   

      
   }

}