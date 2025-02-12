import java.util.Random;

public class StockData {

    // This is subject information (for observing the stock market)
    Double dow = 4016.22; // dow jones
    Double snp = 33743.84; // S&P 500
    Double mmm = 112.93; // 3M stock price
    Double msft = 240.61; // Microsoft stock price

    Random random = new Random();

    public StockData() {

    }

    public StockData(StockData toCopy) {
        dow = toCopy.dow;
        snp = toCopy.snp;
        mmm = toCopy.mmm;
        msft = toCopy.msft;
    }

    @Override
    public String toString() {
        return String.format("DOW %.2f S&P %.2f 3M %.2f Microsoft %.2f",dow,snp,mmm,msft);
    }

	/** Randomly generates stock to create a fake feed of the stock market */
    public void stockGenerator() {
		// Generate some random stock data

		double randDouble;

		// dow and snp can fluctuate in the range of 0 to 5% (+/-)
		// 50/50 chance of the index changing at this time

		if (random.nextDouble() < .50) {
			// change dow
			randDouble = random.nextDouble()*5.0/100;
			if (random.nextDouble()<.5) {   // 50/50 chance of a negative change
				randDouble *= -1;
			}
			dow = dow + randDouble*dow;
		}

		if (random.nextDouble() < .50) {
			// change snp
			randDouble = random.nextDouble()*5.0/100;
			if (random.nextDouble()<.5) {   // 50/50 chance of a negative change
				randDouble *= -1;
			}
			snp = snp + randDouble*snp;
		}

		// stocks can fluctuation in the range of 0 to 2% (+/-)
		// 70/30 chance of 3M changing at this time
		if (random.nextDouble() < .30) {
			// change 3M stock price
			randDouble = random.nextDouble()*2.0/100;
			if (random.nextDouble()<.5) {   // 50/50 chance of a negative change
				randDouble *= -1;
			}
			mmm = mmm + randDouble*mmm;
		}

		// stocks can fluctuation in the range of 0 to 2%
		// 60/40 chance of 3M changing at this time
		if (random.nextDouble() < .40) {
			// change Microsoft stock price
			randDouble = random.nextDouble()*2.0/100;
			if (random.nextDouble()<.5) {   // 50/50 chance of a negative change
				randDouble *= -1;
			}
			msft = msft + randDouble*msft;        
			}
		}
}