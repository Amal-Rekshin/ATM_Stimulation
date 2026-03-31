import java.sql.*;

public class Account {

    public boolean login(String userId, String pin) {
        try (Connection con = DBConnection.getConnection()) {
            String query = "SELECT * FROM accounts WHERE user_id=? AND pin=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, userId);
            ps.setString(2, pin);

            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public double getBalance(String userId) {
        try (Connection con = DBConnection.getConnection()) {
            String query = "SELECT balance FROM accounts WHERE user_id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, userId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble("balance");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void deposit(String userId, double amount) {
        try (Connection con = DBConnection.getConnection()) {
            String query = "UPDATE accounts SET balance = balance + ? WHERE user_id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setDouble(1, amount);
            ps.setString(2, userId);

            ps.executeUpdate();
            System.out.println("Amount Deposited: ₹" + amount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void withdraw(String userId, double amount) {
        try (Connection con = DBConnection.getConnection()) {
            double currentBalance = getBalance(userId);

            if (amount <= 0) {
                System.out.println("Invalid amount.");
                return;
            }

            if (amount > currentBalance) {
                System.out.println("Insufficient balance!");
                return;
            }

            String query = "UPDATE accounts SET balance = balance - ? WHERE user_id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setDouble(1, amount);
            ps.setString(2, userId);

            ps.executeUpdate();
            System.out.println("Withdrawal Successful: ₹" + amount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
