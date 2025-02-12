import java.util.*;

public class NewsFeed extends Subject implements Runnable {

    NewsData news = new NewsData();

    public void notifyObservers() {
        news.headlineGenerator();
        for (Observer obs : observers()) {
            obs.update(new NewsData(news));
        }
    }

    public void run() {
        
        while (true) {
        	notifyObservers();
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
        
            }
        } // end while
    } // end run
    
} // end class NewsFeed