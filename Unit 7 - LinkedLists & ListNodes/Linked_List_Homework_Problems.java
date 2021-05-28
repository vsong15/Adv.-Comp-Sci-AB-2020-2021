import java.util.LinkedList;
public class Linked_List_Homework_Problems{
   public static void main(String[]args){
      //Task 1
      LinkedList<String> cookware = new LinkedList<String>();
      cookware.add("Pan");
      System.out.println(cookware);
      //Task 2
      cookware.add("Wok");
      cookware.add("Skillet");
      System.out.println(cookware);
      //Task 3
      cookware.remove("Wok");
      System.out.println(cookware);
      //Task 4
      cookware.add(1, "Pot");
      System.out.println(cookware);
      //Task 5
      cookware.get(2);
      System.out.println(cookware.get(2)); 
      //Task 6
      cookware.addFirst("Griddle");
      System.out.println(cookware); 
   }
}