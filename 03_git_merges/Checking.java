public class Checking extends Account {
	
	// incremented with each new checking account creation
	private static Integer uniqueAccountNumber = 100100;
	
	/** 
	* Default constructor initializes account with unique account number and $0 balance.
	*/
	public Checking() {
		super(uniqueAccountNumber);
		uniqueAccountNumber++;
	} // end constructor
	
	@Override
	public void withdrawal(double amount) {
		if (amount > balance()) {
			System.out.println("Insufficient Funds. Fee of $25.00 charged to account.");
			chargeFee(25.00);
			return;
		}
		super.withdrawal(amount);
	} // end withdrawal
	
} // end class Checking