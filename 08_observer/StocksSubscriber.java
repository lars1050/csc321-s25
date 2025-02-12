import java.awt.Color;
import javax.swing.*;
import java.util.*;

public class StocksSubscriber extends JPanel implements Observer {

	private final int W_PANEL = 300;
	private final int H_PANEL = 200;
	
	private JLabel title = new JLabel("Current Stock Market Value");
	
	private JLabel date = new JLabel("Date");
	
	// set up labels and corresponding values within the panel
	
	private JLabel dowLabel = new JLabel("Dow Jones Index: ");
	private JLabel dowValue = new JLabel(" - ");
	
	private JLabel snpLabel = new JLabel("S&P 500 Index: ");
	private JLabel snpValue = new JLabel(" - ");
	
	private JLabel mmmLabel = new JLabel("3M: ");
	private JLabel mmmValue = new JLabel(" - ");
	
	private JLabel msftLabel = new JLabel("Microsoft: ");
	private JLabel msftValue = new JLabel(" - ");
	
	Date d1 = new Date(); 

	// Source/subject that supplies the stock market updates
  	StocksFeed feed = null;

	// data structure for sharing info between subject and observer
  	StockData stocksData;

	/** Constructor
	@param feed Provides stock market updates
	@param row position within the frame
	@param col position within the frame
	*/
  	public StocksSubscriber(StocksFeed feed, int row, int col) {
  	
  		// register with the subject to get the feed
    	this.feed = feed;
    	feed.subscribe(this);
    	
    	setLayout(null);
    	
    	// set in graphics window
    	setBounds(row,col,W_PANEL,H_PANEL);
        setBorder(BorderFactory.createLineBorder(Color.black));
        
        
        // arrange all the components of the panel
        
        title.setBounds(10,0,W_PANEL,20);
        add(title);
        
        date.setBounds(10,180,W_PANEL,20);
        date.setText((new Date()).toString());
        add(date);
        
        dowLabel.setBounds(10,30,150,20);
        dowValue.setBounds(155,30,100,20);
        dowValue.setHorizontalAlignment(SwingConstants.RIGHT);
        add(dowLabel);
        add(dowValue);

        snpLabel.setBounds(10,60,150,20);
        snpValue.setBounds(155,60,100,20);
        snpValue.setHorizontalAlignment(SwingConstants.RIGHT);
        add(snpLabel);
        add(snpValue);
        
        mmmLabel.setBounds(10,90,150,20);
        mmmValue.setBounds(155,90,100,20);
        mmmValue.setHorizontalAlignment(SwingConstants.RIGHT);
        add(mmmLabel);
        add(mmmValue);
        
        msftLabel.setBounds(10,120,150,20);
        msftValue.setBounds(155,120,100,20);
        msftValue.setHorizontalAlignment(SwingConstants.RIGHT);
        add(msftLabel);
        add(msftValue);
        
        setVisible(true);
  	}

  	/* Receiving an update from the subject. */
  	public void update(Object data) {

    	if (data instanceof StockData) {
    		// get the data from the structure and update the display
      		stocksData = (StockData) data;
      		dowValue.setText(String.format("%10.3f",stocksData.dow));
      		snpValue.setText(String.format("%10.3f",stocksData.snp));
      		mmmValue.setText(String.format("%10.3f",stocksData.mmm));
      		msftValue.setText(String.format("%10.3f",stocksData.msft));
      		date.setText((new Date()).toString());
    	}
  	}
}
