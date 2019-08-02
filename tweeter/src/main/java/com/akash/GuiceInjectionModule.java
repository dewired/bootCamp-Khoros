package com.akash;

import com.akash.resources.TweetResource;
import com.akash.services.TweetService;
import com.akash.services.impl.TweetServiceImpl;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import ru.vyarus.dropwizard.guice.module.support.DropwizardAwareModule;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class GuiceInjectionModule extends DropwizardAwareModule<AppConfig> {

    TweetResource resource;
    GuiceInjectionModule(TweetResource resource) {
        this.resource = resource;
    }

    @Override
    protected void configure() {


        bind(String.class).annotatedWith(Names.named("consumerKey")).toInstance(configuration().getConsumerKey());
        bind(String.class).annotatedWith(Names.named("consumerSecret")).toInstance(configuration().getConsumerSecret());
        bind(String.class).annotatedWith(Names.named("accessToken")).toInstance(configuration().getAccessToken());
        bind(String.class).annotatedWith(Names.named("accessTokenSecret")).toInstance(configuration().getAccessTokenSecret());
        bind(Twitter.class).toInstance(TwitterFactory.getSingleton());
        bind(Long.class).annotatedWith(Names.named("expTime")).toInstance(configuration().getExpTime());
//        bind(TweetResource.class).to(TweetResource.class);
        bind(TweetService.class).to(TweetServiceImpl.class);
    }

}
