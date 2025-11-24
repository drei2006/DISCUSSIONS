import java.util.Scanner;

public class ATMMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ATMSystem display = new ATMSystem();

        String accountName = "Kathryn Bernardo";
        double balance = 50000.00;

        String choice = "";

        while (!choice.equalsIgnoreCase("X")) {

            display.showMenu();
            choice = input.next();

            if (choice.equals("1")) {  
                System.out.print("Enter amount to deposit: ");
                double amount = input.nextDouble();

                if (amount > 0) {
                    balance += amount;
                    display.depositSuccess();
                } else {
                    display.invalidAmount();
                }

            } else if (choice.equals("2")) {  
                System.out.print("Enter amount to withdraw: ");
                double amount = input.nextDouble();

                if (amount > 0 && amount <= balance) {
                    balance -= amount;
                    display.withdrawSuccess();
                } else {
                    display.insufficientFunds();
                }

            } else if (choice.equals("3")) {  
                display.showDetails(accountName, balance);

            } else if (choice.equalsIgnoreCase("X")) { 
                display.exitMessage();

            } else {  
                display.invalidOption();
            }
        }

        input.close();
    }
}
