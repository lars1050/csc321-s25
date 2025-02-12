import javax.swing.*;
import java.awt.Font;
import java.awt.Color;


public class NewsSubscriber extends JPanel implements Observer {

	private final int W_PANEL = 605;
	private final int H_PANEL = 100;
	
	private boolean subscribed = true;
	
	private JLabel headline = new JLabel("Headline");
	
	// Store a series of headlines to be combined and scrolled across the screen.
	String allHeadlines[] = { 
		" No news is good news. ",
		" No news is good news. ",
		" No news is good news. ",
		" No news is good news. ",
		" No news is good news. "
	};
	
	// At each iteration, the string "shifts" to the left. This is accomplished
	// by creating a new substring that starts at index (of all concatenated headlines).
	Integer index = 0;
	
	// Essentially creating a circular buffer to fill with the latest headlines
	Integer headlineIndex = 0;
	
	// Maximum length of the scrolling text within the panel
	Integer scrollLength = 100;

	// Source (Subject) of the headlines
    NewsFeed newsfeed = null;

	// Data structure for sharing info between subject and observer
    NewsData theNews;

	/** Constructor
	@param newsfeed Source of the headlines.
	@param row placement of panel within frame.
	@param col placement of panel within frame.
	*/
    public NewsSubscriber(NewsFeed newsfeed, int row, int col) {
    
    	// subscribe to the feed that provides the headlines.
        this.newsfeed = newsfeed;
        newsfeed.subscribe(this);
        
        // establish panel
        setBounds(row,col,W_PANEL,H_PANEL);
        setBorder(BorderFactory.createLineBorder(Color.black));
        
        headline.setBounds(0, 0, W_PANEL, H_PANEL);
        headline.setFont(new Font("Verdana", Font.PLAIN, 16));
        add(headline);
        
        setVisible(true);
        
		// controls the timing of the scroll across the panel
        Timer timer = new Timer(300, e -> {
        	if (subscribed) {
				updateHeadline();
			}
		});
		timer.start();
    }

    /** Receiving an update from the subject. */
    public void update(Object data) {

        if (data instanceof NewsData) {
			// cast the object 
        	NewsData news = (NewsData) data;
        	
        	// store in the next place within the circular buffer
            allHeadlines[headlineIndex] = news.getHeadline();
            headlineIndex = (headlineIndex + 1) % allHeadlines.length;
        }
    }

	/** Set the text to advance the scrolling text */
    public void updateHeadline() {
    	// create one big string with all headlines.
    	String allText = allHeadlines[0]+allHeadlines[1]+allHeadlines[2]+allHeadlines[3];
    	//System.out.println(allText);
    	// since the length changed, make sure the index is valid
    	if (index >= allText.length()) {
    		index = 0;
    	}
    	// take the string from [index] to the end
    	String scrollText = allText.substring(index);
    	
    	// if too short, wrap around and take some characters from the front
    	int count = allText.length() - index + 1;
    	if (count < scrollLength) {
    		scrollText += allText.substring(0,scrollLength-count+1);	
    	}
    	
		// change the text in the panel. advance the pointer to the next char
        headline.setText(scrollText);
        index = (index+1) % allText.length();
    }
} // end class Newsfeed