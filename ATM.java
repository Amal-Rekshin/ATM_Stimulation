import java.util.Scanner;

class ATM {
    private Account account;
    private Scanner sc;
    private String userId;

    public ATM(Account account, String userId) {
        this.account = account;
        this.userId = userId;
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
                case 1:
                    System.out.println("Current Balance: ₹" + account.getBalance(userId));
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    double dep = sc.nextDouble();
                    if (dep > 0) account.deposit(userId, dep);
                    else System.out.println("Invalid amount!");
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ₹");
                    double w = sc.nextDouble();
                    account.withdraw(userId, w);
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}



