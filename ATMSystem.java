import java.util.Scanner;

public class ATMSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account account = new Account();

        System.out.println("===== Welcome to ATM System =====");

        System.out.print("Enter User ID: ");
        String userId = sc.nextLine();

        System.out.print("Enter PIN: ");
        String pin = sc.nextLine();

        if (account.login(userId, pin)) {
            System.out.println("Login Successful!");
            ATM atm = new ATM(account, userId);
            atm.showMenu();
        } else {
            System.out.println("Invalid credentials!");
        }

        sc.close();
    }
}




// javac -cp .:mysql-connector-j-9.6.0.jar *.java
// java -cp .:mysql-connector-j-9.6.0.jar ATMSystem