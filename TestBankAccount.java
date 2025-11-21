import java.util.*;

public class TestBankAccount 
{
   public static void main(String[] args)
   {
      BankAccount savings = new BankAccount("Juan Dela Cruz", 5000);
      savings.displayDetails();
      if(savings.deposit(15000) == true)
      {
         System.out.println("Successfully deposited.");
      }
      else 
      {
         System.out.println("Sorry, deposit was unsuccessful. Minimum of 100 and maximum of 500,000.00 only.");
      }
      savings.displayDetails();
      
      if(savings.withdraw(3000) == true)
      {
         System.out.println("Successfully withdrawn.");
      }
      else 
      {
         System.out.println("Sorry, withdrawal was unsuccessful. Minimum of 100 and maximum of 50,000.00 only, must be divisible by 100, and must not exceed your existing balance.");
      }
      savings.displayDetails();
   }
}