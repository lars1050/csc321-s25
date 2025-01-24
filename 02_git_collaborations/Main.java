public class Main {

    public static void main(String[] args) {
    
    	double score = 0;
    
    	try {
	    	score = test_checking();
	    	System.out.println("Percent correct: " + score);
	    } catch (Exception e) {
	    	System.out.println("CRASH in checking test.");
	    	e.printStackTrace();
	    }
	    
	    try {
	    	score = test_savings();
	    	System.out.println("Percent correct: " + score);
	    } catch (Exception e) {
	    	System.out.println("CRASH in savings test.");
	    	e.printStackTrace();
	    }
	    
	    try {
	    	score = test_retirement();
	    	System.out.println("Percent correct: " + score);
	    } catch (Exception e) {
	    	System.out.println("CRASH in retirement test.");
	    	e.printStackTrace();
	    }
    } // end main()
    
    // _________________________________________________________________
    // ______________________   TEST CHECKING __________________________
    
    public static double test_checking() {
      System.out.println("\n______ TEST CHECKING _____________");
      int pass = 0;
      
      // test constructor 
      Checking checking = new Checking();
      if (checking.balance() == 0.0) {
      	pass++;
      } else {
      	System.out.println("Failed opening balance of $0.");
      }
      
      checking.deposit(100.50);
      if (checking.balance() == 100.50) {
      	pass++;
      } else {
      	System.out.println("Failed deposit.");
      }
      checking.withdrawal(50.00);
      if (checking.balance() == 50.50) {
      	pass++;
      } else {
      	System.out.println("Failed withdrawal.");
      	}
      
      double b = checking.balance();
      System.out.println("EXPECT Insufficient Funds.");

      // attempt to overdraw by $50 (25.00 fee)
      checking.withdrawal(b + 50.0);
      if (checking.balance() == b-25.0) {
      	pass++;
      } else {
      	System.out.println("Failed fee charge.");
      }
      return pass/4.0*100.0;
    } // end test_checking()
    

    // _________________________________________________________________
    // ______________________   TEST SAVINGS __________________________
    
    public static double test_savings() {

      System.out.println("\n______ TEST SAVINGS _____________");
      int pass = 0;
      
      Savings savings = new Savings();
      if (savings.accountNumber() == 200100) {
      	pass++;
      } else {
      	System.out.println("Failed first account number of 200100");
      }

      if (savings.balance() == 0.0) {
      	pass++;
      } else {
      	System.out.println("Failed opening balance of $0.");
      }
      
      if (savings.interestRate() == 0.005) {
      	pass++;
      } else {
      	System.out.println("Failed default interest rate of .005");
      }
      
      savings = new Savings(0.03);
      if (savings.accountNumber() == 200101) {
      	pass++;
      } else {
      	System.out.println("Failed 2nd account number of 200101");
      }
      
      if (savings.interestRate() == 0.03) {
      	pass++;
      } else {
      	System.out.println("Failed to set interest rate of .03");
      }
      
      savings.deposit(200);
      if (savings.balance() == 200.0) {
      	pass++;
      } else {
      	System.out.println("Failed deposit 200.");
      }
      
      double b = savings.balance();
      savings.applyInterest();
      if (savings.balance() == b+b*.03/12.0) {
      	pass++;
      } else {
      	System.out.println("Failed applying interest.");
      }
      
      b = savings.balance();
      savings.withdrawal(b-10.0);
      if (savings.balance() == 10.0) {
      	pass++;
      } else {
      	System.out.println("Failed on withdraw.");
      }
      
      b = savings.balance();
      System.out.println("EXPECT Insufficient Funds.");
      savings.withdrawal(b+10.0);
      if (savings.balance() == b) {
      	pass++;
      } else {
      	System.out.println("Failed on overdraw.");
      }
      
      return pass/9.0*100.0;
      
    }
    
    // _________________________________________________________________
    // ______________________   TEST RETIREMENT __________________________
    
	public static double test_retirement() {
      System.out.println("\n______ TEST Retirement _____________");
      int pass = 0;

      Retirement retirement = new Retirement();
      if (retirement.accountNumber() == 300100) {
      	pass++;
      } else {
      	System.out.println("Failed first account number of 300100");
      }

      if (retirement.balance() == 0.0) {
      	pass++;
      } else {
      	System.out.println("Failed opening balance of $0.");
      }
      
      retirement = new Retirement(0.05);
      if (retirement.accountNumber() == 300101) {
      	pass++;
      } else {
      	System.out.println("Failed 2nd account number of 300101");
      }
      
      retirement.deposit(300);
      if (retirement.balance() == 300.0) {
      	pass++;
      } else {
      	System.out.println("Failed on deposit");
      }
      
      double b = retirement.balance();
      retirement.applyInterest();
      if (retirement.balance() == b+b*.05/12.0) {
      	pass++;
      } else {
      	System.out.println("Failed on applied interest.");
      }
      
      b = retirement.balance();
      System.out.println("EXPECT Withrawal not permitted.");
      retirement.withdrawal(10.0);
      if (retirement.balance() == b) {
      	pass++;
      } else {
      	System.out.println("Failed on withdrawal.");
      }
      
      return pass/6.0*100.0;
      
    } // end test_retirement()
}
