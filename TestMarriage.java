import java.util.Scanner;

public class TestMarriage 
{
   public static void main(String[] args)
   {
      //for academic purposes only, no hate intended, love love love
      Person kenneth = new Person("Egos", "Kenneth", "P", 'M', 22);
      Person kathryn = new Person("Bernardo", "Kathryn", "", 'F', 21);
      kenneth.displayDetails();
      kathryn.displayDetails();
      
      if(kenneth.marry(kathryn))
      {
         System.out.println("Just Married...");
      }
      else 
      {
         System.out.println("Sorry, not compatible. No hate intended, Minor love love love.");
      }
      
      kathryn.displayDetails();
      
   }
}
