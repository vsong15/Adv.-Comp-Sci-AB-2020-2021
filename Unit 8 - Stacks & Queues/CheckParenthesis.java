
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CheckParenthesis{

   public static void main(String[] args){      
      
      System.out.println(checkParen("5 + 7"));
      System.out.println(checkParen("(5 + 7)"));
      System.out.println(checkParen(")5 + 7("));
      System.out.println(checkParen("((5 + 7)*3)"));
      System.out.println(checkParen("<{5 + 7}*3>"));
      System.out.println(checkParen("[(5 + 7)*]3"));
      System.out.println(checkParen("(5+7)*3"));
      System.out.println(checkParen("5+(7*3)"));
      System.out.println(checkParen("((5+7)*3"));
      System.out.println(checkParen("[(5+7]*3"));
      System.out.println(checkParen("[(5+7)*3"));
      System.out.println(checkParen("[(5+7)*3])"));
      
   }  
   
   public static boolean checkParen(String str){
      boolean match = false;
      Stack<String> s = new Stack<String>();
      String sub;
      char tempchar; 
      String tempstr;
      
      // Iterate through each character in the string and process parenthesis
      for(int i = 0; i < str.length(); i++){
         sub = str.substring(i,i+1);
         tempchar = str.charAt(i); 
         
         // When an open/close parenthesis symbol is found, process it
         if(isParenSymbol(tempchar)){
            if(isOpenParen(tempchar)){
               s.push(sub);
            } else if(isCloseParen(tempchar)){
               // If the there is nothing on the stack it can't be matched
               if(s.empty()){
                  return false;
               } 
               
               // Check to see if the open/close parenthesis match
               tempstr = s.pop();
               if(!openCloseMatch(tempstr,sub)){
                  return false;
               }
            }
         }
      
      }
      
      // Final checks
      if(s.empty()){
         return true;
      } else {
         return false;
      }
   }
   
   public static boolean isParenSymbol(char ch){
      return (isCloseParen(ch) || isOpenParen(ch));
   }
   
   public static boolean isOpenParen(char ch){
      String left_paren  = "([{<";
      return left_paren.indexOf(ch) != -1;
   }
   
   public static boolean isCloseParen(char ch){
      String right_paren  = ")]}>";
      return right_paren.indexOf(ch) != -1;
   }
   
   public static boolean openCloseMatch(String a, String b){
      if(a.equals("(") && b.equals(")")){
         return true;
      }
      if(a.equals("[") && b.equals("]")){
         return true;
      }
      if(a.equals("{") && b.equals("}")){
         return true;
      }
      if(a.equals("<") && b.equals(">")){
         return true;
      }
   
      return false;
   }
   
}
