import java.util.ArrayList;
public class ArrayListMethods{
   public static void main(String[]args){
   
   //********************** size() ************************
   
      ArrayList<Integer> intlist = new ArrayList<>();
      intlist.add(10);
      intlist.add(20);
      intlist.add(30);
      intlist.add(40);
      
      System.out.println(intlist.size());
   	
      
   
   //********************** add(E obj) ************************
   /*
      ArrayList<Integer> intlist = new ArrayList<>();
      intlist.add(10);
      intlist.add(20);
      intlist.add(30);
      intlist.add(40);
   */
      System.out.println(intlist);
      
      intlist.add(100);
      
      System.out.println(intlist);
   
   
   //********************** add(int index, E obj) ************************
   /*
      ArrayList<Integer> intlist = new ArrayList<>();
      intlist.add(10);
      intlist.add(20);
      intlist.add(30);
      intlist.add(40);
   */   
      System.out.println(intlist);
   
      intlist.add(1,100);
      
      System.out.println(intlist);
   
   
   //********************** get(int index) ************************
   /*
      ArrayList<Integer> intlist = new ArrayList<>();
      intlist.add(10);
      intlist.add(20);
      intlist.add(30);
      intlist.add(40);
   */   
      
      System.out.println(intlist.get(1));
   
   
   
   //********************** set(int index, E obj) ************************
    /*
      ArrayList<Integer> intlist = new ArrayList<>();
      intlist.add(10);
      intlist.add(20);
      intlist.add(30);
      intlist.add(40);
   */   
      
      System.out.println(intlist);
   
      intlist.set(1,100);
      
      System.out.println(intlist);
   
   
   //********************** remove(int index) ************************
   /*
      ArrayList<Integer> intlist = new ArrayList<>();
      intlist.add(10);
      intlist.add(20);
      intlist.add(30);
      intlist.add(40);
   */   
      
      System.out.println(intlist);
      
      intlist.remove(1);
      
      System.out.println(intlist);
   
   
   
   
   
   }
}