import twitter4j.*;

//import java.io.IOException;
import java.util.List;

public class Tweeter {

    private static Twitter tweeter = TwitterFactory.getSingleton();
    private static List<Status> home;

    public void tweetPost(String tweet) {

        try {
            Status statusUpdate = tweeter.updateStatus(tweet);
        } catch (TwitterException e) {
            return;
        }

    }

    public void getHome(int n) {

        Paging page = new Paging(1, n);

        try {
            home = tweeter.getHomeTimeline(page);
        } catch (TwitterException e) {
            return;
        }

        while (n > 0) {

            n--;

            System.out.println("Tweet #" + (n+1) + " by " + home.get(n).getUser().getScreenName() + ": " + home.get(n).getText());

        }

    }

    public static void main(String[] args) {

        Tweeter tweeter = new Tweeter();

        String tweet = "Thanks @t4j_news!";

        //tweetPost(tweet);

        tweeter.getHome(5);
    }

}
