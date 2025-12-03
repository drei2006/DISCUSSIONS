import javax.swing.JOptionPane;

 class Account {
    String name;
    double balance;

    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }
}

// Main ATM program
public class FinalProject3 {
    static Account account1 = null;
    static Account account2 = null;

    public static void main(String[] args) {
        while (true) {
            String menu = "ATM Machine\n\n" +
                    "1. Open an Account\n" +
                    "2. Deposit\n" +
                    "3. Withdraw\n" +
                    "4. Send Money\n" +
                    "5. Display Accounts\n" +
                    "6. Exit\n\n" +
                    "Choose an option:";

            int choice = getIntInput(menu);

            if (choice == 1) {
                openAccount();
            } else if (choice == 2) {
                deposit();
            } else if (choice == 3) {
                withdraw();
            } else if (choice == 4) {
                sendMoney();
            } else if (choice == 5) {
                displayAccounts();
            } else if (choice == 6) {
                JOptionPane.showMessageDialog(null, "Exiting ATM. Goodbye!", "ATM Machine", JOptionPane.PLAIN_MESSAGE);
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid choice.", "ATM Machine", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    public static void openAccount() {
        if (account1 != null && account2 != null) {
            JOptionPane.showMessageDialog(null, "Maximum of 2 accounts already created.", "ATM Machine", JOptionPane.PLAIN_MESSAGE);
            return;
        }

        String name = JOptionPane.showInputDialog(null, "Enter account name:", "ATM Machine", JOptionPane.PLAIN_MESSAGE);
        if (name == null || name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Name cannot be empty.", "ATM Machine", JOptionPane.PLAIN_MESSAGE);
            return;
        }

        double initialDeposit = getDoubleInput("Enter initial deposit (min 2000, max 100000):");

        if (initialDeposit < 2000 || initialDeposit > 100000) {
            JOptionPane.showMessageDialog(null, "Invalid amount. Must be between 2000 and 100000.", "ATM Machine", JOptionPane.PLAIN_MESSAGE);
            return;
        }

        if (account1 == null) {
            account1 = new Account(name, initialDeposit);
            JOptionPane.showMessageDialog(null, "Account 1 created successfully!", "ATM Machine", JOptionPane.PLAIN_MESSAGE);
        } else {
            account2 = new Account(name, initialDeposit);
            JOptionPane.showMessageDialog(null, "Account 2 created successfully!", "ATM Machine", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public static void deposit() {
        Account acc = chooseAccount();
        if (acc == null) return;

        double amount = getDoubleInput("Enter amount to deposit:");
        if (amount <= 0) {
            JOptionPane.showMessageDialog(null, "Amount must be positive.", "ATM Machine", JOptionPane.PLAIN_MESSAGE);
            return;
        }

        acc.balance += amount;
        JOptionPane.showMessageDialog(null, "Deposit successful.\nNew Balance: " + acc.balance, "ATM Machine", JOptionPane.PLAIN_MESSAGE);
    }

    public static void withdraw() {
        Account acc = chooseAccount();
        if (acc == null) return;

        double amount = getDoubleInput("Enter amount to withdraw:");
        if (amount <= 0) {
            JOptionPane.showMessageDialog(null, "Amount must be positive.", "ATM Machine", JOptionPane.PLAIN_MESSAGE);
            return;
        }

        if (amount > acc.balance) {
            JOptionPane.showMessageDialog(null, "Insufficient balance.", "ATM Machine", JOptionPane.PLAIN_MESSAGE);
            return;
        }

        acc.balance -= amount;
        JOptionPane.showMessageDialog(null, "Withdrawal successful.\nNew Balance: " + acc.balance, "ATM Machine", JOptionPane.PLAIN_MESSAGE);
    }

    public static void sendMoney() {
        if (account1 == null || account2 == null) {
            JOptionPane.showMessageDialog(null, "Both accounts must exist to send money.", "ATM Machine", JOptionPane.PLAIN_MESSAGE);
            return;
        }

        int choice = getIntInput("Send money:\n1. Account1 → Account2\n2. Account2 → Account1");
        double amount = getDoubleInput("Enter amount to send:");

        if (amount <= 0) {
            JOptionPane.showMessageDialog(null, "Amount must be positive.", "ATM Machine", JOptionPane.PLAIN_MESSAGE);
            return;
        }

        if (choice == 1) {
            if (amount > account1.balance) {
                JOptionPane.showMessageDialog(null, "Insufficient balance in Account 1.", "ATM Machine", JOptionPane.PLAIN_MESSAGE);
                return;
            }
            account1.balance -= amount;
            account2.balance += amount;
            JOptionPane.showMessageDialog(null, "Transfer successful!", "ATM Machine", JOptionPane.PLAIN_MESSAGE);
        } else if (choice == 2) {
            if (amount > account2.balance) {
                JOptionPane.showMessageDialog(null, "Insufficient balance in Account 2.", "ATM Machine", JOptionPane.PLAIN_MESSAGE);
                return;
            }
            account2.balance -= amount;
            account1.balance += amount;
            JOptionPane.showMessageDialog(null, "Transfer successful!", "ATM Machine", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid choice.", "ATM Machine", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public static void displayAccounts() {
        String result = "";
        if (account1 != null)
            result += "Account 1: " + account1.name + " | Balance: " + account1.balance + "\n";
        else
            result += "Account 1: [Not Created]\n";

        if (account2 != null)
            result += "Account 2: " + account2.name + " | Balance: " + account2.balance + "\n";
        else
            result += "Account 2: [Not Created]\n";

        JOptionPane.showMessageDialog(null, result, "ATM Machine", JOptionPane.PLAIN_MESSAGE);
    }

    public static Account chooseAccount() {
        int c = getIntInput("Choose account:\n1. Account 1\n2. Account 2");

        if (c == 1) {
            if (account1 == null) {
                JOptionPane.showMessageDialog(null, "Account 1 not created yet.", "ATM Machine", JOptionPane.PLAIN_MESSAGE);
                return null;
            }
            return account1;
        } else if (c == 2) {
            if (account2 == null) {
                JOptionPane.showMessageDialog(null, "Account 2 not created yet.", "ATM Machine", JOptionPane.PLAIN_MESSAGE);
                return null;
            }
            return account2;
        } else {
            JOptionPane.showMessageDialog(null, "Invalid choice.", "ATM Machine", JOptionPane.PLAIN_MESSAGE);
            return null;
        }
    }

    public static int getIntInput(String msg) {
        while (true) {
            try {
                return Integer.parseInt(JOptionPane.showInputDialog(null, msg, "ATM Machine", JOptionPane.PLAIN_MESSAGE));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Invalid input. Enter a number.", "ATM Machine", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    public static double getDoubleInput(String msg) {
        while (true) {
            try {
                return Double.parseDouble(JOptionPane.showInputDialog(null, msg, "ATM Machine", JOptionPane.PLAIN_MESSAGE));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Invalid number.", "ATM Machine", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
}
