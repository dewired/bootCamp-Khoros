package com.akash;

import com.akash.resources.TweetResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
//import com.akash.AppConfig.java;


public class Main extends Application<AppConfig> {

    //private Twitter twitter;
    private long expTime;

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
    public void run(AppConfig appConfig, Environment environment) throws Exception {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey(appConfig.getConsumerKey());
        cb.setOAuthConsumerSecret(appConfig.getConsumerSecret());
        cb.setOAuthAccessToken(appConfig.getAccessToken());
        cb.setOAuthAccessTokenSecret(appConfig.getAccessTokenSecret());
        expTime = appConfig.getExpTime();
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter =  tf.getInstance();


//        final GetHomePage resource = new GetHomePage(twitter);
//        final TweetMessage tweeter = new TweetMessage(twitter);
//        environment.jersey().register(resource);
//        environment.jersey().register(tweeter);

        final TweetResource resource = new TweetResource(twitter, expTime);

        environment.jersey().register(resource);

    }
}