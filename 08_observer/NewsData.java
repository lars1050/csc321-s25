import java.util.Random;

public class NewsData {

    private String headline = "No news is good news!";

    Random random = new Random();

    public NewsData() {
        headlineGenerator();

    }

    public NewsData(NewsData toCopy) {
        headline = toCopy.headline;
    }

    @Override
    public String toString() {
        return headline;
    }

    public String getHeadline() {
        return headline;
    }

	/** Randomly generate a new headline for the feeed */
    public void headlineGenerator() {

        String[] good = {"exciting", "fantasic", "good", "positive","improving","great","helpful","miraculous"};
        String[] bad = {"unfortunate","sad","bad","negative","deteriorating","distressing","catastrophic"};
        String[] context = {"technology","politics","local events","national events","world events","sports","entertainment","science"};

        String about = context[random.nextInt(context.length)];
        String goodbad = "";

        // 70% chance of good news for a change
        if (random.nextDouble() < .70) {
            // good news
            goodbad = good[random.nextInt(good.length)];
        } else {
            goodbad = bad[random.nextInt(bad.length)];
        }

		/** The headline will be read by the Observers */
        headline = " The latest news in "+about+" is "+goodbad+"! ";
    }
}