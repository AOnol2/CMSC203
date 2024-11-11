public class SavingsAccount extends BankAccount {
    private static final double ANNUAL_RATE = 0.025; // Annual interest rate
    private int savingsNumber = 0; // Tracks the specific savings account for a user
    private String accountNumber; // Customized account number format for savings accounts

    // Constructor for the first savings account
    public SavingsAccount(String name, double initialDeposit) {
        // Initialize BankAccount with name and initial deposit
        super(name, initialDeposit);
        // Customize account number with a savings-specific suffix
        this.accountNumber = super.getAccountNumber() + "-" + savingsNumber;
    }

    // Adds monthly interest to the balance
    public void postInterest() {
        double monthlyInterest = getBalance() * (ANNUAL_RATE / 12);
        deposit(monthlyInterest); // Deposit the interest into the account
    }

    // Returns the customized account number
    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    // Copy constructor: sets up a new savings account based on an existing one
    public SavingsAccount(SavingsAccount original, double initialDeposit) {
        // Call BankAccount's copy constructor
        super(original, initialDeposit);
        // Increment savings number to make each account unique
        this.savingsNumber = original.savingsNumber + 1;
        // Customize account number with the new savings number
        this.accountNumber = super.getAccountNumber() + "-" + savingsNumber;
    }
}
