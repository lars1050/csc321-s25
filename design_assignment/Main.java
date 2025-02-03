import java.util.ArrayList;
import java.util.Random;

public class Main {

	// random items are generated
	private static Random random = new Random();

	public static void main(String[] args) {

		// Create a list of potential items to place in a cart
		ArrayList<Item> items = new ArrayList<>();
		for (int i=0; i<20; i++) {
		
			// create random items that might be purchased
			Item item = new Item();
			// set random id, price, and quantity
			item.id = random.nextInt(9000) + 1000;
			item.price = (double)random.nextInt(5) + random.nextInt(100)/100.0;
			item.quantity = random.nextInt(4)+1;
			items.add(item);
		}

		//------------------------- Create an Order --------------------------

		// Create a cart for purchase and randomly select 5 items to add 
		Cart cart1 = new Cart();
		Item[] cartItems1 = new Item[10];
		for (int i=0; i<5; i++) {
			cartItems1[i] = items.get(random.nextInt(items.size()));
		}
		
		// add the items to the cart
		cart1.itemsList = cartItems1;
		cart1.itemCount = 5;

		// Finish the purchase by putting it into an Order
		Order order1 = new Order(cart1, .077,"Suzy Queue","suziq@gmail.com","612-111-2222");

		// Print Order Receipt
		System.out.println("\nOrder for "+order1.customerName() + ". Contact at "+order1.customerEmail());
		for (int i=0; i<order1.cart().itemCount; i++) {
			System.out.println(order1.cart().itemsList[i]);
		}
		System.out.println("____________________");
		System.out.printf("     Total $%5.2f %n", order1.total());
		
		
		//------------------------- Another Order --------------------------
		
		// Create a cart for purchase and randomly select items to add 
		Cart cart2 = new Cart();
		Item[] cartItems2 = new Item[10];
		for (int i=0; i<3; i++) {
			cartItems2[i] = items.get(random.nextInt(items.size()));
		}
		
		// add items to the cart
		cart2.itemsList = cartItems2;
		cart2.itemCount = 3;

		// Finish the purchase by putting it into an Order
		Order order2 = new Order(cart2, .077,"Ali Stack","astack@gmail.com","612-333-4444");

		// Print order receipt
		System.out.println("\n\nOrder for "+order2.customerName() + ". Contact at "+order2.customerEmail());
		for (int i=0; i<order2.cart().itemCount; i++) {
			System.out.println(order2.cart().itemsList[i]);
		}
		System.out.println("____________________");
		System.out.printf("     Total $%5.2f %n", order2.total());
		
		System.out.println();
		
		//------------------------- Another Order --------------------------
		
		// Create a cart for purchase and randomly select items to add 
		Cart cart3 = new Cart();
		Item[] cartItems3 = new Item[10];
		for (int i=0; i<7; i++) {
			cartItems3[i] = items.get(random.nextInt(items.size()));
		}
		
		// add items to the cart
		cart3.itemsList = cartItems3;
		cart3.itemCount = 7;

		// Finish the purchase by putting it into an Order
		Order order3 = new Order(cart3, .077,"Suzy Queue","suziq@gmail.com","612-111-2222");

		// Order Receipt
		System.out.println("\nOrder for "+order3.customerName() + ". Contact at "+order3.customerEmail());
		for (int i=0; i<order3.cart().itemCount; i++) {
			System.out.println(order3.cart().itemsList[i]);
		}
		System.out.println("____________________");
		System.out.printf("     Total $%5.2f %n", order3.total());
	}
}


