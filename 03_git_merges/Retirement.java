/** 
Retirement is a subtype of the Account class.
It has a default interest rate of 3.0%
*/
public class Retirement extends Account {

	/** Provides each new account with a unique account number. */
	private static Integer uniqueAccountNumber = 300100;

	/** 
	* Constructor initializes account with unique account number and $0 balance.
	* @param rate annual interest rate
	*/
	public Retirement(double rate) {
		super(uniqueAccountNumber);
		uniqueAccountNumber++;
		super.interestRate(rate);
	} // end constructor
	
	/**
	* Default constructor that has default interest rate.
	*/
	public Retirement() {
		this(0.03);
	}
	
	@Override
	public void withdrawal(double amount) {
		System.out.println("Withdrawal not permitted from retirement account.");
	}

} // end class Retirement
