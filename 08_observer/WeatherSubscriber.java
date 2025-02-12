import javax.swing.*;
import java.util.*;
import java.awt.*;


public class WeatherSubscriber extends JPanel implements Observer {

	private final int W_PANEL = 300;
	private final int H_PANEL = 200;
	
	private JLabel title = new JLabel("Weather Info");
	
    WeatherFeed feed = null;

    WeatherData theWeather;

    public WeatherSubscriber(WeatherFeed feed, int row, int col) {
    
        this.feed = feed;
        feed.subscribe(this);
        
        setLayout(null);
        
        setBounds(row,col,W_PANEL,H_PANEL);
        setBorder(BorderFactory.createLineBorder(Color.black));
        
    }

    /* Receiving an update from the subject. */
    public void update(Object data) {

        if (data instanceof WeatherData) {

      	}

    }

} // end class Newsfeed