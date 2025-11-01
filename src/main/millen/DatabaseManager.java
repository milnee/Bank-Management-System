package main.millen;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DatabaseManager {

    private File file = new File("accounts.txt");

    public Map<String, BankAccount> loadAccounts() {
        Map<String, BankAccount> accounts = new HashMap<>();
        
        if (!file.exists()) {
            return accounts;
        }
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] data = line.split("Account Number: | Name: | Balance: £");
                if (data.length >= 4) {
                    String accountNumber = data[1].trim();
                    String accountHolder = data[2].trim();
                    double balance = Double.parseDouble(data[3].trim());
                    
                    BankAccount account = new BankAccount(accountNumber, accountHolder, balance);
                    accounts.put(accountNumber, account);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return accounts;
    }
    
    public void saveAccounts(Map<String, BankAccount> accounts) {
        try {
            PrintWriter writer = new PrintWriter(file);
            for (Map.Entry<String, BankAccount> entry : accounts.entrySet()) {
                writer.println("Account Number: " + entry.getKey() + " Name: " + entry.getValue().getAccountHolder() + " Balance: £" + entry.getValue().getBalance());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}