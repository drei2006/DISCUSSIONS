public class TestMarriage 
{
   public static void main(String[] args)
   {
      //for academic purposes only, no hate intended, love love love
      Person kenneth = new Person("Egos", "Kenneth", "P", 'M');
      Person kathryn = new Person("Bernardo", "Kathryn", "", 'F');
      kenneth.displayDetails();
      kathryn.displayDetails();
      
      if(kenneth.marry(kathryn))
      {
         System.out.println("Just Married...");
      }
      else 
      {
         System.out.println("Sorry, not compatible. No hate intended, love love love.");
      }
      
      kathryn.displayDetails();
      
   }
}