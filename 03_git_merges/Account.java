public abstract class Account {

	/** Unique identifying account number */
	private Integer accountNumber = null;
	
	/** Current balance for the account */
	private double balance = 0.0;
	
	/** Annual Interest Rate (earned) */
	private double interestRate = 0.0;
	
	/** 
	* Constructor for instantiating subclass
	* @param number unique account number supplied by subclass
	*/
	public Account(Integer number) {
		accountNumber = number;
	}
	
    /** 
    * Adding to the balance.
    * @param amount total deposit amount 
    */
    public void deposit(double amount) {
    	balance += amount;
    }

    /** 
    * Subtracting from the balance
    * @param amount total withdrawal amount 
    */
    public void withdrawal(double amount) {
    	balance -= amount;
    }
    
    /**
    * Subtract from balance an incurred fee
    * @param fee amount to charge to account
    */
    public void chargeFee(double amount) {
    	balance -= amount;
    }
    
    /**
    * Apply monthly earned interest rate.
    */
    public void applyInterest() {
    	double earned = interestRate/12.0 * balance;
    	balance += earned;
    }
    
    // --------------------- SETTERS and GETTERS ---------------------
    
    /** getter for the current balance */
    public double balance() {
    	return balance;
    }

    /** getter for unique account number */
    public int accountNumber() {
    	return accountNumber;
    }
    
    /** setter for interest rate */
    public void interestRate(double rate) {
    	interestRate = rate;
    }
     
    /** getter for interest rate */
    public double interestRate() {
    	return interestRate;
    }
}
