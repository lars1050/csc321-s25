import java.util.Random;

public class WeatherData {

    // This is subject information (for observing the weather)
    Integer temperature = 10; // minneapolis temp
    Integer precipitation = 7; // chance of precip
    Integer airQuality = 46; // air quality index

    Random random = new Random();

    public WeatherData() {

    }

    public WeatherData(WeatherData toCopy) {
        temperature = toCopy.temperature;
        precipitation = toCopy.precipitation;
        airQuality = toCopy.airQuality;
    }

    @Override
    public String toString() {
        return String.format("temp %d  precip %d%%  air %d",temperature,precipitation,airQuality);
    }

    public void weatherGenerator() {
        // Generate some random weather data
        // temp, precip, air

        int randInteger;
        double randDouble;

        // temp can fluctuate in the range of -1 to 1 degree
        // 80/20 chance of the temp changing at this time

        if (random.nextDouble() < .20) {
            // change temp
            if (random.nextDouble() < .5) { // 50/50 chance of a negative change
                temperature = temperature + 1;
            } else {
                temperature = temperature - 1;
            }
        }

        // chance of precip can fluctuate in the range of 0 to 5% (+/-)
        // 60/40 chance of the temp changing at this time

        if (random.nextDouble() < .40) {
            // change precip
            randInteger = random.nextInt(5);
            if (random.nextDouble() < .5) { // 50/50 chance of a negative change
                precipitation = precipitation - randInteger;
                if (precipitation < 0) {
                    precipitation = 0;
                }
            } else {
                precipitation = precipitation + randInteger;
                if (precipitation > 100) {
                    precipitation = 100;
                }
            }
        }

        // chance of air quality index can fluctuate in the range of 0 to 1 (+/-)
        // 90/10 chance of the temp changing at this time

        if (random.nextDouble() < .10) {
            // change air quality index
            randInteger = random.nextInt(2);
            if (random.nextDouble() < .5) { // 50/50 chance of a negative change
                airQuality = airQuality - randInteger;
                if (airQuality < 0) {
                    airQuality = 0;
                }
            } else {
                airQuality = airQuality + randInteger;
                if (airQuality > 100) {
                    airQuality = 100;
                }
            }
        }

    }
}