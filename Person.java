public class Person 
{
   private String lastname;
   private String firstname;
   private String middlename;
   private char sex;
   
   public Person()
   {
      this.lastname = "-";
      this.firstname = "-";
      this.middlename = "-";
      this.sex = 'F';
   }
   
   public Person(String lastname, String firstname, String middlename, char sex)
   {
      this.lastname = lastname;
      this.firstname = firstname;
      this.middlename = middlename;
      this.sex = sex;
   }
   
   public void setLastname(String lastname){     this.lastname = lastname; }
   public void setFirstname(String firstname){   this.firstname = firstname; }
   public void setMiddlename(String middlename){ this.middlename = middlename; }
   public void setSex(char sex)                 {this.sex = sex; }
   
   public String getLastname(){   return this.lastname; }
   public String getFirstname(){  return this.firstname; }
   public String getMiddlename(){ return this.middlename;   }
   public char getSex(){          return this.sex; }
   
   public void displayDetails()
   {
      System.out.println(this.getLastname() + ", " + this.getFirstname() + " " + this.getMiddlename() + " (" + this.getSex() + ") ");
   }
   
   public boolean marry(Person partner)
   {
      //first, identify who is female
      //is it the this? or is it the partner variable?
      
      if(
            (this.getSex() == 'M' && partner.getSex() == 'F')
            ||
            (this.getSex() == 'F' && partner.getSex() == 'M')  
        )
        {
            //identify who is female
            if(this.getSex() == 'F')
            {
               this.middlename = this.lastname; //her middlename will become her lastname
               this.lastname = partner.getLastname(); //change this girl's lastname to her partner's lastname
               //meaning, partner is male
            }
            else 
            {
               //partner is female
               partner.setMiddlename(partner.getLastname()); //change partner's middlename to partner's lastname
               partner.setLastname(this.lastname); //change partner's lastname to this lastname
               //meaning "this" is the male
            }
            
            return true;
        }
        else 
        {
            return false;
        }
   }
   
}