import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
            return false;
        }
        this.balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
            return false;
        }
        if (this.balance >= amount) {
            this.balance -= amount;
            return true;
        } else {
            System.out.println("Insufficient funds for withdrawal.");
            return false;
        }
    }

    public double checkBalance() {
        return this.balance;
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public String withdraw(double amount) {
        if (account.withdraw(amount)) {
            return "Withdrawal successful. Remaining balance: " + account.checkBalance();
        } else {
            return "Withdrawal failed.";
        }
    }

    public String deposit(double amount) {
        if (account.deposit(amount)) {
            return "Deposit successful. New balance: " + account.checkBalance();
        } else {
            return "Deposit failed.";
        }
    }

    public String checkBalance() {
        return "Current balance: " + account.checkBalance();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Initialize bank account with $1000 balance
        BankAccount bankAccount = new BankAccount(1000);
        ATM atm = new ATM(bankAccount);

        // Sample usage
        System.out.println(atm.checkBalance()); // Check initial balance

        System.out.println(atm.withdraw(500)); // Withdraw $500
        System.out.println(atm.withdraw(700)); // Try to withdraw $700 (insufficient funds)

        System.out.println(atm.deposit(300)); // Deposit $300
        System.out.println(atm.checkBalance()); // Check updated balance
    }
}
