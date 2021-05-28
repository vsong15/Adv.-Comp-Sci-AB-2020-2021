
import java.util.LinkedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DataCSVLoader {

   // Database loader method
   public LinkedList<PhoneBookEntry> LoadCSVDatabase(String full_path) {
   
      // Initialize the database list
      LinkedList<PhoneBookEntry> pb_database = new LinkedList<>();
      PhoneBookEntry tempdata = null;
      int counter = 0;
   
      try {
         File myObj = new File(full_path);
         Scanner myReader = new Scanner(myObj);
         while (myReader.hasNextLine()) {
            String datastring = myReader.nextLine();
            if(counter > 0){
               tempdata = parseCSVLine(datastring);
               pb_database.add(tempdata);
            }
            counter++; 
         }
         myReader.close();
      } catch (FileNotFoundException e) {
         System.out.println("An error occurred.");
         e.printStackTrace();
      }
   
      // Return the database list
      return pb_database;
   }

   private PhoneBookEntry parseCSVLine(String linestring) {
      
      // Tokenize the string (parse based on commas)
      StringTokenizer Tok = new StringTokenizer(linestring,",");
              
      // Extract the data from the string
      String firstname = Tok.nextToken();
      String lastname = Tok.nextToken();
      String phonenumber = Tok.nextToken();
      String agestring = Tok.nextToken();
      int age = Integer.parseInt(agestring);
      
      // Create & return the phone book entry
      PhoneBookEntry tempdata = new PhoneBookEntry(firstname,lastname,phonenumber,age);
      return tempdata;
      
   }

}