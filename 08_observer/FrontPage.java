import javax.swing.JFrame;
import javax.swing.JCheckBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;

/** Front Page of a customizable newsfeed. */
public class FrontPage extends JFrame {

	/** Width of the frame/window */
	private final int W_FRAME = 630;
	
	/** Height of the frame/window */
	private final int H_FRAME = 550;
	
	// News feeds for anyone who wants to subscribe
	static private NewsFeed newsFeed = new NewsFeed(); // <=== thread
	static private StocksFeed stocksFeed = new StocksFeed();	// <=== thread
	static private WeatherFeed weatherFeed = new WeatherFeed();
	static private ImagesFeed imagesFeed = new ImagesFeed();
	
	// Check boxes to subscribe and unsubscribe from a feed
	private JCheckBox newsCheck = new JCheckBox("Headline Feed");
	private JCheckBox stocksCheck = new JCheckBox("Stock Market Feed");
	private JCheckBox weatherCheck = new JCheckBox("Weather Feed");
	private JCheckBox imagesCheck = new JCheckBox("Image Feed");
	
	/** Placement of the the images feed */
	private final int IMAGES_ROW = 100;
	
	/** Placement of the stock market AND weather feed */
	private final int STOCKS_ROW = 250;
	
	/** placement of the News scroll feed */
	private final int HEADLINES_ROW = 450;
	
	// Observers of the corresponding feeds.
	// They inherit from Observer and JPanel
	private NewsSubscriber newsSubscriber;
	private StocksSubscriber stocksSubscriber;
	private WeatherSubscriber weatherSubscriber;
	private ImagesSubscriber imagesSubscriber;
	
	/** Constructor to create window and components.
	@param title graphics window title
	*/
	public FrontPage(String title) {
	
		super(title);

		// set up the window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(W_FRAME,H_FRAME);
		
		// You control the layout, not the graphics app
		getContentPane().setLayout(null);
		
		// place the check box for subscribe/unsubscribe
		newsCheck.setBounds(50,10,200,40);
		stocksCheck.setBounds(50,40,200,40);
		weatherCheck.setBounds(320,10,200,40);
		imagesCheck.setBounds(320,40,200,40);
		
		// use the string "news" to identify which box checked
		newsCheck.setActionCommand("news");
		newsCheck.addActionListener(checkListener);
		add(newsCheck);
		
		// use string "stocks" to identify which box checked
		stocksCheck.setActionCommand("stocks");
		stocksCheck.addActionListener(checkListener);
		add(stocksCheck);
		
		// establishing action listener and adding to frame
		weatherCheck.setActionCommand("weather");
		weatherCheck.addActionListener(checkListener);
		add(weatherCheck);
		
		imagesCheck.setActionCommand("images");
		imagesCheck.addActionListener(checkListener);
		add(imagesCheck);
		
		// panel for the news feed
		newsSubscriber = new NewsSubscriber(newsFeed, 10, HEADLINES_ROW);
		add(newsSubscriber);
		
		// panel for the images feed
		imagesSubscriber = new ImagesSubscriber(imagesFeed, 10, IMAGES_ROW);
		add(imagesSubscriber);
		
		// panel for the stock market feed
		stocksSubscriber = new StocksSubscriber(stocksFeed, 10, STOCKS_ROW);
		add(stocksSubscriber);
		
		// panel for the weather feed
		weatherSubscriber = new WeatherSubscriber(weatherFeed, W_FRAME/2, STOCKS_ROW);
		add(weatherSubscriber);
		
		setVisible(true);
		
		// Each thread periodically updates the feed.
		// When it updates, it informs its observer
		
		Thread newsThread = new Thread(newsFeed);
		newsThread.start();
		
		Thread marketThread = new Thread(stocksFeed);
		marketThread.start();
		
		Thread weatherThread = new Thread(weatherFeed);
		weatherThread.start();
		
		Thread imagesThread = new Thread(imagesFeed);
		imagesThread.start();
	
	} // end constructor
	
	ActionListener checkListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent ae) {
			
			String command = ae.getActionCommand(); 
			
			if (command.equals("news")) {
				System.out.println("news");
			
			} else if (command.equals("stocks")) {
				System.out.println("stocks");
			
			} else if (command.equals("weather")) {
				System.out.println("weather");
			
			} else if (command.equals("images")) {
				System.out.println("images");
			
			} else {
				System.out.println("did not recognize "+command);
			}
		}
	};
	
} // end class