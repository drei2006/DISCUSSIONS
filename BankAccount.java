/*
   accountNo: String
   accountName: String
   balance: double   
*/
import java.util.*;
public class BankAccount
{
   private String accountNo;
   private String accountName;
   private double balance;
   
   public BankAccount()
   {
      accountNo = "-";
      accountName = "-";
      balance = 0.0;     
   }
   
   public BankAccount(String accountName, double balance)
   {
      this.accountNo = new Random().nextInt(1000) + "";
      this.accountName = accountName;
      this.balance = balance;
   }
   
   public void setAccountName(String accountName){ this.accountName = accountName; }
   
   public String getAccountNo(){    return this.accountNo; }
   public String getAccountName(){  return this.accountName; }
   public double getBalance(){      return this.balance; }
   
   public void displayDetails()
   {
      System.out.println("Account No.: " + this.accountNo);
      System.out.println("Account Name: " + this.accountName);
      System.out.printf("Balance: %.2f\n", this.balance);
   }
   
   public boolean deposit(double amount)
   {
      /*
         amount must not be a negative number.
         amount per transaction must not exceed 500,000.00
         minimum amount to be deposited is 100.00
      */
      /*
      if(amount < 100 || amount > 500000)
         return false;        
      this.balance = this.balance + amount;
      return true;      
      */
      
      if(amount >= 100 && amount <= 500000)
      {
         this.balance = this.balance + amount;
         return true;
      }
      else
      {
         return false;
      }      
   }
   
   public boolean withdraw(double amount)
   {
      /*
         must have enough balance
         minimum amount to be withdrawn 100
         maximum withdrawal amount must not exceed 50,000.00
         must be divisible by 100
      */
      
      //if(amount < 100 || amount > 50000 || amount % 100 != 0 || amount > this.balance)
      
      if(amount < 100)
         return false;
         
      if(amount > 50000)
         return false;
         
      if(amount % 100 != 0)
         return false;
         
      if(amount > this.balance)
         return false;
         
      this.balance = this.balance - amount;
      return true;  
       
         
      
      
      
      
      
   }
   
   
      
}

