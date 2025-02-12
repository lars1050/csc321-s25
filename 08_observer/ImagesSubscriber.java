import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.*;

/** Observer of the image feed, which is displayed in the panel */
public class ImagesSubscriber extends JPanel implements Observer {

	private final int W_PANEL = 605;
	private final int H_PANEL = 150;
	
	private JLabel title = new JLabel("Image Feed");

	/** Source of the news feed */
    ImagesFeed feed = null;

	/** Data structure for passing information between subject and observer */
    ImagesData imageData;
    
	/** Images for displaying in the panel. These are changed when feed updates */
    BufferedImage[] imagesDisplayed = new BufferedImage[3];

	/** Constructor:
	@param feed Source of the Images (the Subject)
	@param row Placement of the panel in the frame
	@param col Placement of the panel in the frame
	*/
    public ImagesSubscriber(ImagesFeed feed,int row, int col) {
    	
    	// register/subscribe with the feed
        this.feed = feed;
        feed.subscribe(this);
        
        // place this panel in the window
        setBounds(row,col,W_PANEL,H_PANEL);
        setBorder(BorderFactory.createLineBorder(Color.black));
        
        title.setBounds(0, 0, W_PANEL, H_PANEL);
        title.setFont(new Font("Verdana", Font.PLAIN, 24));
        //add(title);
        
        setVisible(true);
    }

    /* Receiving an update from the subject. */
    public void update(Object data) {

        if (data instanceof ImagesData) {
        	// shift the images over and add new image to the end
    		imagesDisplayed[0] = imagesDisplayed[1];
    		imagesDisplayed[1] = imagesDisplayed[2];
    		imagesDisplayed[2] = ((ImagesData) data).image;
        	repaint();
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Draw each of the 3 images within the panel
        if (null != imagesDisplayed[0]) {
			g.drawImage(imagesDisplayed[0], 0, 0, 200, 200, null);
		}
		if (null != imagesDisplayed[1]) {
			g.drawImage(imagesDisplayed[1], 200,0, 200,200, null);
		}
		if (null != imagesDisplayed[2]) {
			g.drawImage(imagesDisplayed[2], 400,0, 200,200, null);
		}
    }
} // end class Newsfeed