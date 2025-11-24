public class ATMSystem {

    public void showMenu() {
        System.out.println("\nMy ATM Machine");
        System.out.println("==== MENU ====");
        System.out.println("[1] Deposit");
        System.out.println("[2] Withdraw");
        System.out.println("[3] Display Details");
        System.out.println("[X] Exit");
        System.out.print("Please select an option: ");
    }

    public void showDetails(String name, double balance) {
        System.out.println("\n=== ACCOUNT DETAILS ===");
        System.out.println("Account Name: " + name);
        System.out.printf("Current Balance: %.2f\n", balance);
    }

    public void depositSuccess() {
        System.out.println("Successfully deposited!");
    }

    public void withdrawSuccess() {
        System.out.println("Successfully withdrawn!");
    }

    public void invalidAmount() {
        System.out.println("Invalid amount!");
    }

    public void insufficientFunds() {
        System.out.println("Insufficient funds or invalid amount!");
    }

    public void invalidOption() {
        System.out.println("Invalid option. Try again!");
    }

    public void exitMessage() {
        System.out.println("Exiting... Thank you!");
    }
}
