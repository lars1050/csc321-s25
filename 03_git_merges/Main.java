public class Main {

    public static void main(String[] args) {
    
    	double score = 0;
    
    	try {
	    	test_checking();
	    } catch (Exception e) {
	    	System.out.println("CRASH in checking test.");
	    	e.printStackTrace();
	    }
	    
	    try {
	    	test_savings();
	    } catch (Exception e) {
	    	System.out.println("CRASH in savings test.");
	    	e.printStackTrace();
	    }
	    
	    try {
	    	test_retirement();
	    } catch (Exception e) {
	    	System.out.println("CRASH in retirement test.");
	    	e.printStackTrace();
	    }
    } // end main()
    
    public static void test_checking() {
      System.out.println(  "\n__________________________________");
      System.out.println("______ TEST CHECKING _____________");
      
      // test constructor 
      Checking checking = new Checking();
      
      checking.deposit(100.50);
      checking.withdrawal(50.00);
      checking.withdrawal(5.00);
      checking.withdrawal(100.00);
      checking.deposit(22.50);

      System.out.println("\nTransactions");
      System.out.println("====================================");
      checking.displayTransactions();
      
    } // end test_checking()
    
    public static void test_savings() {

      System.out.println(  "\n__________________________________");
      System.out.println("______ TEST SAVINGS _____________");
      
      Savings savings = new Savings(0.03);
      
      savings.deposit(20);
      savings.applyInterest();
      savings.withdrawal(10.0);
      savings.withdrawal(100.0);
      savings.deposit(212.12);   
      
      System.out.println("\nTransactions");
      System.out.println("====================================");
      savings.displayTransactions();   
    }
    
	public static void test_retirement() {
      System.out.println(  "\n____________________________________");
      System.out.println("______ TEST Retirement _____________");
      int pass = 0;
      
      Retirement retirement = new Retirement(0.05);
      retirement.deposit(2000);
      retirement.applyInterest();
      retirement.withdrawal(100.0);
      retirement.deposit(500.50);   
      
      System.out.println("\nTransactions");
      System.out.println("====================================");
      retirement.displayTransactions(); 
      
    } // end test_retirement()
}
