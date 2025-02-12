import java.util.*;

public class StocksFeed extends Subject implements Runnable {

    StockData stocks = new StockData();

    public void notifyObservers() {
        stocks.stockGenerator();
        for (Observer obs : observers()) {
            obs.update(new StockData(stocks));
        }
    }

    public void run() {
        while (true) {
            notifyObservers();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            }
        }
    }
}