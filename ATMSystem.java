package ATM_Stimulation;

import java.util.Scanner;
class Account {
    private String userId = "user123";
    private String pin = "1234";
    private double balance = 5000;

    public boolean login(String enteredUserId, String enteredPin) {
        return enteredUserId.equals(userId) && enteredPin.equals(pin);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Amount Deposited: ₹" + amount);
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return false;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance!");
            return false;
        }
        balance -= amount;
        System.out.println("Withdrawal Successful: ₹" + amount);
        return true;
    }
}

class ATM {
    private Account account;
    private Scanner sc;

    public ATM(Account account) {
        this.account = account;
        this.sc = new Scanner(System.in);
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                // case variable:
                        
                case 1:
                    System.out.println("Current Balance: ₹" + account.getBalance());
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    double dep = sc.nextDouble();
                    if (dep > 0) account.deposit(dep);
                    else System.out.println("Invalid amount!");
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ₹");
                    double w = sc.nextDouble();
                    account.withdraw(w);
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM!");
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account account = new Account();
        ATM atm = new ATM(account);

        System.out.println("===== Welcome to ATM System =====");

        // Login
        System.out.print("Enter User ID: ");
        String userId = sc.nextLine();

        System.out.print("Enter PIN: ");
        String pin = sc.nextLine();

        if (account.login(userId, pin)) {
            System.out.println("Login Successful!");
            atm.showMenu();
        } else {
            System.out.println("Invalid User ID or PIN!");
        }

        sc.close();
    }
}
