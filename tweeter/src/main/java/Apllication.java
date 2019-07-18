import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
//import Config.java;


public class Apllication extends Application<Config> {

    private Twitter twitter;
    Config config = new Config();

    public static void main(String[] args) throws Exception {

        new Apllication().run(args);
    }
    public Apllication()
    {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey(config.getConsumerKey());
        cb.setOAuthConsumerSecret(config.getConsumerSecret());
        cb.setOAuthAccessToken(config.getAccessToken());
        cb.setOAuthAccessTokenSecret(config.getAccessTokenSecret());
        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();
    }
//    private String consumerKey = getConsumerKey

//    @Override
    public void initialize() {
        // nothing to do yet

    }



    @Override
    public void run(Config config, Environment environment) throws Exception {
        final GetHomePage resource = new GetHomePage(
                twitter
        );
        final TweetMessage tweeter = new TweetMessage(
                config.getConsumerKey(),
                config.getConsumerSecret(),
                config.getAccessToken(),
                config.getAccessTokenSecret()
        );
        environment.jersey().register(resource);
        environment.jersey().register(tweeter);
    }
}