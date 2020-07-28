package com.akash;

//import com.akash.resources.TweetResource;
import com.google.inject.Guice;
import com.google.inject.Injector;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import ru.vyarus.dropwizard.guice.GuiceBundle;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
//import com.akash.AppConfig.java;


public class Main extends Application<AppConfig> {

    //private Twitter twitter;
    private long expTime;
    // TweetResource resource;
    private static Twitter twitter = null;

    public static Twitter getTwitterInstance(){
        return twitter;
    }

    public static void main(String[] args) throws Exception {
        new Main().run(args);
    }
//    private String consumerKey = getConsumerKey

    @Override
    public void initialize(Bootstrap<AppConfig> bootstrap) {
//        bootstrap.addBundle(GuiceBundle.builder()
//                .enableAutoConfig(getClass().getPackage().getName())
//                .modules(new GuiceInjectionModule(resource))
//                .build());
        bootstrap.addBundle(new AssetsBundle("/assets","/home","index.html"));
    }



    @Override
    public void run(AppConfig appConfig, Environment environment) throws Exception {
//
//        ConfigurationBuilder cb = new ConfigurationBuilder();
//        cb.setDebugEnabled(true);
//        cb.setOAuthConsumerKey(appConfig.getConsumerKey());
//        cb.setOAuthConsumerSecret(appConfig.getConsumerSecret());
//        cb.setOAuthAccessToken(appConfig.getAccessToken());
//        cb.setOAuthAccessTokenSecret(appConfig.getAccessTokenSecret());
//        expTime = appConfig.getExpTime();
//        TwitterFactory tf = new TwitterFactory(cb.build());
//        twitter =  tf.getInstance();
//        resource = new TweetResource(expTime);
//
////        final GetHomePage resource = new GetHomePage(twitter);
////        final TweetMessage tweeter = new TweetMessage(twitter);
////        environment.jersey().register(resource);
////        environment.jersey().register(tweeter);
//
//        environment.jersey().register(resource);

    }
}