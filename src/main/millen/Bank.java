package main.millen;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Bank {

    private Scanner scanner = new Scanner(System.in);
    private Map<String, BankAccount> accounts = new HashMap<>();
    private DatabaseManager dbManager = new DatabaseManager();
    

    public void menu() {
        System.out.println("--------------------------------");
        System.out.println("Bank Management System");
        System.out.println("1. Create account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Check balance");
        System.out.println("5. Exit");
        System.out.println("--------------------------------");
    }

    public void createAccount() {
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Enter your account number: ");
        String accountNumber = scanner.nextLine();
        
        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account number already exists!");
            return;
        }
        
        BankAccount account = new BankAccount(accountNumber, name, 0.0);
        accounts.put(accountNumber, account);
        dbManager.saveAccounts(accounts);
        System.out.println("Account created successfully!");
    }

    public void deposit() {
        System.out.println("Enter the account number: ");
        String accountNumber = scanner.nextLine();
        
        BankAccount account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        
        System.out.println("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        
        account.deposit(amount);
        dbManager.saveAccounts(accounts);
        System.out.println("Deposit successful! New balance: " + account.getBalance());
    }
    
    public void withdraw() {
        System.out.println("Enter the account number: ");
        String accountNumber = scanner.nextLine();
        
        BankAccount account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        
        System.out.println("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        
        if (amount > account.getBalance()) {
            System.out.println("Insufficient balance!");
            return;
        }
        
        account.withdraw(amount);
        dbManager.saveAccounts(accounts);
        System.out.println("Withdrawal successful! New balance: " + account.getBalance());
    }
    
    public void checkBalance() {
        System.out.println("Enter the account number: ");
        String accountNumber = scanner.nextLine();
        
        BankAccount account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        System.out.println("--------------------------------");
        System.out.println("Account Details:");
        System.out.println("Account Holder: " + account.getAccountHolder());
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Balance: £" + account.getBalance());
        System.out.println("--------------------------------");

    }

    public void exit() {
        System.out.println("Thank you for using the bank management system");
        System.exit(0);
    }
    
    public void run() {
        accounts = dbManager.loadAccounts();
        
        while (true) {
            menu();
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    exit();
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.run();
    }
}

