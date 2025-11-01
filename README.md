# Bank Management System

A simple command-line Bank Management System built with Java that allows users to create accounts, deposit money, withdraw funds, and check balances. All account data is persisted locally in a text file.

## Features

- ✅ **Create Account**: Create new bank accounts with account number and holder name
- 💰 **Deposit Money**: Add funds to existing accounts
- 💸 **Withdraw Money**: Withdraw funds with balance validation
- 📊 **Check Balance**: View account details and current balance
- 💾 **Data Persistence**: All accounts are automatically saved to `accounts.txt`
- 🔄 **Auto-Load**: Accounts are automatically loaded when the application starts

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- A Java compiler (javac) and runtime (java)

## Installation

1. Clone the repository:
```bash
git clone https://github.com/yourusername/bank-management-system.git
cd bank-management-system
```

2. Compile the Java files:
```bash
javac -d . src/main/millen/*.java
```

## Running the Application

Run the application from the project root directory:

```bash
java main.millen.Bank
```

## Usage

When you run the application, you'll see a menu with the following options:

```
--------------------------------
Bank Management System
1. Create account
2. Deposit
3. Withdraw
4. Check balance
5. Exit
--------------------------------
```

### Creating an Account

1. Select option `1` from the menu
2. Enter the account holder's name
3. Enter a unique account number
4. The account will be created with a balance of £0.00

### Depositing Money

1. Select option `2` from the menu
2. Enter the account number
3. Enter the amount to deposit
4. The balance will be updated automatically

### Withdrawing Money

1. Select option `3` from the menu
2. Enter the account number
3. Enter the amount to withdraw
4. The system will validate if sufficient balance exists
5. If valid, the balance will be updated

### Checking Balance

1. Select option `4` from the menu
2. Enter the account number
3. View the account details including holder name, account number, and current balance

### Exiting

Select option `5` to exit the application. All data will be saved automatically.

## Project Structure

```
Bank Management System/
├── src/
│   └── main/
│       └── millen/
│           ├── Bank.java           # Main application class with menu and operations
│           ├── BankAccount.java    # Account model class
│           └── DatabaseManager.java # File I/O operations for persistence
├── accounts.txt                     # Data storage file (auto-generated)
└── README.md                        # This file
```

## Data Storage

Account data is stored in `accounts.txt` in the following format:

```
Account Number: <number> Name: <holder> Balance: £<amount>
```

Example:
```
Account Number: 1 Name: Millen Balance: £100000.0
Account Number: 2 Name: John Doe Balance: £500.50
```

The file is automatically created when you create your first account and is loaded every time the application starts.

## Technologies Used

- **Java**: Core programming language
- **File I/O**: For local data persistence
- **HashMap**: For in-memory account storage
- **Scanner**: For user input handling

## Features in Detail

### Data Persistence
- Accounts are saved automatically after every operation (create, deposit, withdraw)
- All existing accounts are loaded from `accounts.txt` when the application starts
- No manual save required - data persists between sessions

### Validation
- Prevents duplicate account numbers
- Validates account existence before operations
- Checks for sufficient balance before allowing withdrawals
- Input validation for account numbers and amounts

## Future Enhancements

Potential improvements for future versions:
- Transaction history
- Account transfer functionality
- Interest calculation
- Multiple currency support
- GUI interface
- Database integration (SQLite/MySQL)
- User authentication
- Admin panel

## License

This project is open source and available for educational purposes.

## Contributing

Contributions, issues, and feature requests are welcome! Feel free to check the issues page.

## Author

**milnee**

---

**Note**: This is a simple educational project. For production banking systems, additional security measures, encryption, and proper database systems should be implemented.

