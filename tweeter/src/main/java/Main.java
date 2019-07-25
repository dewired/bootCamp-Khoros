import com.akash.resources.TweetResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
//import Config.java;


public class Main extends Application<Config> {

    //private Twitter twitter;

    public static void main(String[] args) throws Exception {

        new Main().run(args);
    }
    public Main()
    {


    }
//    private String consumerKey = getConsumerKey

//    @Override
    public void initialize() {
        // nothing to do yet


    }



    @Override
    public void run(Config config, Environment environment) throws Exception {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey(config.getConsumerKey());
        cb.setOAuthConsumerSecret(config.getConsumerSecret());
        cb.setOAuthAccessToken(config.getAccessToken());
        cb.setOAuthAccessTokenSecret(config.getAccessTokenSecret());
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter =  tf.getInstance();


//        final GetHomePage resource = new GetHomePage(twitter);
//        final TweetMessage tweeter = new TweetMessage(twitter);
//        environment.jersey().register(resource);
//        environment.jersey().register(tweeter);

        final TweetResource resource = new TweetResource(twitter);

        environment.jersey().register(resource);

    }
}