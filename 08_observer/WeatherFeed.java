import java.util.*;

public class WeatherFeed extends Subject implements Runnable {

    WeatherData weather = new WeatherData();

    public void notifyObservers() {
        weather.weatherGenerator();
    	for (Observer obs : observers()) {
        	obs.update(new WeatherData(weather));
        }
    }
    

    public void run() {
        while (true) {
            notifyObservers();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {

            }
        }
    }

}