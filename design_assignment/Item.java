/** Items for purchase */
public class Item {

	/** Unique id for the product */
	int id = 0;

	/** Unit price */
	double price = 0.0;

	/** Quantity being ordered */
	int quantity = 0;

	/** Default constructor */
	public Item() {

	}

	@Override
	public String toString() {
		return String.format("%d : %d at $%4.2f",id,quantity,price); 
	}
}





