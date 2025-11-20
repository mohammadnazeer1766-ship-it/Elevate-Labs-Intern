import java.util.ArrayList;
import java.util.List;
public class Account {
    private String accountNumber;
    private double balance;
    private List<String> transactionHistory;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: " + initialBalance);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive!");
            return;
        }
        balance += amount;
        transactionHistory.add("Deposited: " + amount + ", New Balance: " + balance);
    }
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive!");
            return;
        }
        if (amount > balance) 
            {
            System.out.println("Insufficient balance!");
            return;
        }

        balance -= amount;
        transactionHistory.add("Withdrew: " + amount + ", New Balance: " + balance);
    }
    public double getBalance() {
        return balance;
    }
    public List<String> getTransactionHistory() {
        return transactionHistory;
    }
}
