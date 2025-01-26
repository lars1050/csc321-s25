import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/** Transaction record for a bank account */
public class Transaction {

	/** Transaction types that modify the balance */
	public enum Type { WITHDRAW, DEPOSIT, INTEREST, FEE }

	/** Balance changes by this amount (+/-) */
	private double amount = 0.0;
	
	/** Type of transaction applied to account */
	private Type type = null;
	
	/** Recorded date and time of the transaction */
	private LocalDateTime date = null;
	
	/** Constructor
	* @param amount Changes balance. Can be + or -.
	* @param type Applied this type of transaction 
	*/
	public Transaction( double amount, Type type) {
		this.amount = amount;
		this.type = type;
		// get current date and time
		date = LocalDateTime.now();
	}
	
	@Override
	public String toString() {
	
		// create a formatter for the date time
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

		// Format the data to display the transaction
		String datef = date.format(formatter);
		String typef = String.format("%10s",type);
		String amountf = String.format("$%8.2f",amount);

		return  datef + " " + typef + ": " + amountf ;
	}
}

