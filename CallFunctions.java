
/* creat a function name isEven that requires 1 parameter, an integer number. 
create also another function called squareEven that requires 1 parameter, an even number. 
If the number is even, calculate its square value.*/

import java.util.*;

 public class CallFunctions{
 
   public static boolean isEven(int num){
   
     return (num % 2 == 0);
   }
   
    public static int squareEven(int n){
     /*
     int result;
       
      if(CallFunctions.isEven(n))
      {
        result = n * n;
      }
      else
      {
       result = n;
      }
      
       return result;
     */
     
       //ternary operator expression
       return (CallFunctions.isEven(n) ? n*n : n);
  }
  
   public static void main (String[] args){
   
     Scanner scanner = new Scanner(System.in);
     System.out.println("Enter a number");
      int number = scanner.nextInt();
      int output = CallFunctions.squareEven(number);
     System.out.println("Result: " + output);
   }
}
