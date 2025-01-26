/** 
Savings is a subtype of the Account class.
It has a default interest rate of 0.5%
*/
public class Savings extends Account {

	// incremented with each new checking account creation
	/** Provides each new account with a unique account number. */
	private static Integer uniqueAccountNumber = 200100;

	/** 
	* Constructor initializes account with unique account number and $0 balance.
	* @param rate annual interest rate
	*/
	public Savings(double rate) {
		super(uniqueAccountNumber);
		uniqueAccountNumber++;
		super.interestRate(rate);
	} // end constructor
	
	/**
	* Default constructor that has default interest rate.
	*/
	public Savings() {
		this(0.005);
	}

	
	@Override
	public void withdrawal(double amount) {
		if (amount > balance()) {
			System.out.println("Insufficient Funds for withdrawal.");
			return;
		}
		super.withdrawal(amount);
	} // end withdrawal()

} // end class Savings