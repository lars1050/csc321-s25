import java.util.*;

/** Continuously updates the subject matter and shares with observers */
public class ImagesFeed extends Subject implements Runnable {

	// Data structure for sharing feed data with observers
    ImagesData images = new ImagesData();

	/** Inform all subscribers about new data */
    public void notifyObservers() {
    	// update image
        images.imagesGenerator();
        // share with subscribers
        for (Observer obs : observers()) {
            obs.update(new ImagesData(images));
        }
    }

	/** A thread function that regularly updates the feed */
    public void run() {

        while (true) {
            notifyObservers();
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
            }
        }
    }
}