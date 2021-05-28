import java.util.*;
public class Hash_Code_and_Table_Index_Calculator{

   public static void main(String []args){
      String str = "Senior";
      int table_size = 13;
      int hash_code = str.hashCode();
      int index = Math.abs(hash_code)%table_size;
      System.out.println(Math.abs(hash_code));
      System.out.println(index);
   }
}