
public class PhoneBookEntry{

   // Instance variables
   private String firstname;
   private String lastname;
   private String phonenumber;
   private int age;  
   
   //--------------------------- Constructors
   
   // Defaul constructor
   public PhoneBookEntry(){
      firstname = "";
      lastname = "";
      phonenumber = "";
      age = -1; 
   }
   
   // Constructor with data
   public PhoneBookEntry(String fn, String ln, String pn, int ag){
      firstname = fn;
      lastname = ln;
      phonenumber = pn;
      age = ag;  
   }
   
   
   //--------------------------- Methods
   
   public String getFirstName(){
      return firstname; 
   }
   
   public String getLastName(){
      return lastname;
   }
   
   // Equals Method
   @Override 
   public boolean equals(Object o){
      if(this == o){
         return true;
      }
      
      if (!(o instanceof PhoneBookEntry)) {
            return false;
        }
      
      PhoneBookEntry p = (PhoneBookEntry)o;
      return firstname.equals(p.firstname)
                && lastname.equals(p.lastname)
                && phonenumber.equals(p.phonenumber)
                && (age == p.age); 
   }
   
   // toString() method
   public String toString(){
      return "Name: " + firstname + " " + lastname + "      Phone Number:  " + phonenumber + "    Age: " + age;
   }
   


}