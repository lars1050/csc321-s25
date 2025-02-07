/** A purchase order made from a cart and customer */
public class Order {

	/** The cart of items to be purchased in this order. */
    private Cart cart;
    
    /** Sales tax applicable to the order */
    private double salesTax;

	/** Name of customer making purchase */
    private String customerName;
    
    /** Contact email for customer making purchase */
    private String customerEmail;
    
    /** Contact phone number for customer making purchase */
    private String customerPhone;

	/** Constructor
	* @param c Cart of items to be purchased.
	* @param t tax to apply to order.
	* @param n Name of customer on order.
	* @param e Email of customer on order.
	* @param p Phone number of customer on order.
	*/
    public Order( Cart c, double t, String n, String e, String p ) {
        cart = c;
        salesTax = t;
        customerName = n;
        customerEmail = e;
        customerPhone = p;
      }

	/** Calculates total of purchased items, including sales tax.
	* @return Total cost of purchase (including tax)
	*/
    public double total() {
        float total = 0;
        for (int i=0; i < cart.itemCount; i++) {
          total += cart.itemsList[i].price * cart.itemsList[i].quantity;
        }
        total += total * salesTax;
        return total;
    }
    
    
    // _____________________________________________
    // Getters Below
    
    public Cart cart() {
    	return cart;
    }

    public String customerName() {
      return customerName;
    }
    public String customerEmail() {
      return customerEmail;
    }
    public String customerPhone() {
      return customerPhone;
    }
}





