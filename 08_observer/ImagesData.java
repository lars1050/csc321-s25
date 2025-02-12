import java.util.Random;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.ArrayList;

/** Data Structure for passing image feed data */
public class ImagesData {

	/** The "new" image that is the feed to observers */
	BufferedImage image = null;

	/** Collection of stored images for the feed */
	static String[] imageFiles = {
	"babybunny.jpg", "corgi.jpg", "kittypuppy.jpg", "puppykitty.jpg", "targetpuppy.jpeg", "bunny.jpeg", "dogkitty.jpg", "palmbunny.jpeg", "puppylion.jpg", "bunnyears.jpg", "kitten.jpg", "puppy.jpg", "sleepykitty.jpg" };
	
	/** Saved images ready to be displayed */
	ArrayList<BufferedImage> images = new ArrayList<>();

    Random random = new Random();

    public ImagesData() {
		// store the images in the files in the array
    	for (String fname : imageFiles) {
    		try {
    			images.add(ImageIO.read(new File("images/"+fname)));
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    	image = images.get(0);
    }

	/** Copy constructor for the data to protect it. */
    public ImagesData(ImagesData toCopy) {
    	image = toCopy.image;
    }
    
    /** This is called when it is time to update the feed */
    public void imagesGenerator() {
    	image = images.get(random.nextInt(imageFiles.length));
    }
}