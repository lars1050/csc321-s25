import java.util.concurrent.locks.*;
import java.util.LinkedList;

public class Messenger {

    private String[] mailbox = new String[50]; // longest possible message
    
    private String[] message = null;
    
    private LinkedList<String> messageList = new LinkedList<>();
    
    private ReentrantLock mutex = new ReentrantLock();
    
    private boolean useMutex = false;

    long counter = 0;
    int msgNumber = 0;
    
    public Messenger() {
        messageList.add(new String("A hello to you my friend! Greetings from my vacation in New York NY."));
        
    	messageList.add(new String("I am happy for you that you got to go to New York. It is an exciting place to be."));
    	
    	messageList.add(new String("Yes, having a fabulous time eating well and sight seeing. Wish you were here."));
    	
    	messageList.add(new String("Have some cannoli and pizza for me. And I highly recommend a night viewing from the Empire State Building."));
    	
		messageList.add(new String("Thanks for the tips. I hope all is well with you. I will visit upon my return in a few weeks and share my adventures."));

    }

    public void write() {
    	try {
    	
    		if (useMutex) {
	    		mutex.lock();
	    	}
	    	
			message = messageList.get(msgNumber).split(" ");
	        msgNumber = (msgNumber+1) % messageList.size();
	        
	        int i = 0;
	        while (i < message.length && message[i]!=null) {
        	    mailbox[i] = message[i];
        	    i++;
            	try {
                	Thread.sleep(50);
            	} catch (Exception e) {
            	}
        	}
        	mailbox[message.length] = null;	// indicates end of message
        	counter++;
        	//System.out.println("Done writing.");
        } finally {
        	if (useMutex) {
	        	mutex.unlock();
	        }
        }
    }

    public void read(String[] msg) {
    	try {
    		if (useMutex) {
	    		mutex.lock();
	    	}
	        //System.out.print(" Reading msg...");
	        int i = 0;
	        while (i<mailbox.length && mailbox[i]!=null) {
	    	    msg[i] = mailbox[i];
    			i++;
            	try {
                	Thread.sleep(200);
            	} catch (Exception e) {
            	}
        	}
        	//System.out.println(" Done reading.");
        } finally {
        	if (useMutex) {
	        	mutex.unlock();
	        }
        }
    }
}