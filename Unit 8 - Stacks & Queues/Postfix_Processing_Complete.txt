
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class classes_sandbox{

   public static void main(String[] args){         
      
      // Test case 1
      int r1 = processPostfix("4 7 *");
      System.out.println("Expected: 28 " + "Got: " + r1);
      
      // Test case 2
      int r2 = processPostfix("4 7 2 + *");
      System.out.println("Expected: 36 " + "Got: " + r2);
      
      // Test case 3
      int r3 = processPostfix("3 4 * 5 +");
      System.out.println("Expected: 17 " + "Got: " + r3);
      
   }  
   
   public static int processPostfix(String instring){
      
      // Create a stack for the numbers
      Stack<Integer> intstack = new Stack<Integer>();
      
      // Tokenize the input string by spaces
      StringTokenizer Tok = new StringTokenizer(instring," ");
      
      // Process the string
      /* Your variable declarations here */
      String tempstring ="";
      while(Tok.hasMoreTokens()){
         tempstring = Tok.nextToken();
         
         /* your code here */
         if(isNumeric(tempstring)){
            intstack.add(Integer.parseInt(tempstring));
         }
         if(isOperator(tempstring)){
            intstack.add(doMath(intstack.pop(), intstack.pop(), tempstring));
         }
      }
      return intstack.pop();   
   }
   
   // Check to see if the symbol is an operator
   public static boolean isOperator(String str){
       /* your code here */
      if(str.equals("+") || str.equals("-") || str.equals("/") || str.equals("*") || str.equals("%"))
         return true;
      else
         return false;
   }
   
   // Do the math (operands & operator)
   public static int doMath(int a, int b, String operator){
       /* your code here */
      if(operator.equals("+"))
         return a + b;
      else if(operator.equals("-"))
         return a - b;
      else if(operator.equals("/"))
         return a / b;
      else if(operator.equals("*"))
         return a * b;
      else
         return a % b;
   }
   
   // isNumeric method 
   // Source:  www.baeldung.com/java-check-string-number
   public static boolean isNumeric(String strNum) {
      if (strNum == null) {
         return false;
      }
      try {
         double d = Double.parseDouble(strNum);
      } catch (NumberFormatException nfe) {
         return false;
      }
      return true;
   }
   
}
