public class CheckingAccount extends BankAccount {
    private static final double CHECK_FEE = 0.15; // Fee for processing a check

    // Constructor: sets up a checking account with a name and initial balance
    public CheckingAccount(String name, double initialDeposit) {
        // Pass name and initial deposit to BankAccount constructor
        super(name, initialDeposit);
        // Modify account number for checking account by appending "-10"
        setAccountNumber(getAccountNumber() + "-10");
    }

    // Withdraws money, including a small check processing fee
    @Override
    public boolean withdraw(double amount) {
        // Add check fee to withdrawal amount
        double totalAmount = amount + CHECK_FEE;
        // Use BankAccount's withdraw method and return the result
        return super.withdraw(totalAmount);
    }
}

