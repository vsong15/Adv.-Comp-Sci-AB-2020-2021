
import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;

public class LinkedListPhoneBook{

   public static void main(String[] args){   
        
      // Get the CSV file from the user
      GetFileGUI filegui = new GetFileGUI();
      String fullpath = new String();
      fullpath = filegui.getFileByGUI();
   
      // Parse the CSV file into a database of PhoneBookEntry objects
      DataCSVLoader data_loader = new DataCSVLoader();
      LinkedList<PhoneBookEntry> pb_database;
      pb_database = data_loader.LoadCSVDatabase(fullpath);         
                
      // Print the contents of the database
      PhoneBookEntry tempentry = null;
      for(int i = 0; i < pb_database.size(); i++){
         tempentry = pb_database.get(i);
         System.out.println(tempentry);
      }
      
      // Remove duplicates
      pb_database = removeDuplicates(pb_database); 
      
      // Print the contents of the database
      System.out.println();
      System.out.println();
      System.out.println("Modified Listing - Duplicates Removed: ");
      tempentry = null;
      for(int i = 0; i < pb_database.size(); i++){
         tempentry = pb_database.get(i);
         System.out.println(tempentry);
      }
        
   } 
   
   // Method to remove duplicates
   public static LinkedList<PhoneBookEntry> removeDuplicates(LinkedList<PhoneBookEntry> pb_database){
      for(int i = 0; i < pb_database.size(); i++)
         for(int j = i+1; j < pb_database.size(); j++)   
            if(pb_database.get(i).toString().equals(pb_database.get(j).toString())){
               pb_database.remove(j);
               j--;
            }
      return pb_database;   
      
   }
   
      
}