package com.akash.services;

import com.akash.services.impl.TweetServiceImpl;
import com.akash.services.impl.TweetServiceImpl2;

public class TweetServiceFactory {

    private final static TweetServiceFactory factory = new TweetServiceFactory();

    private TweetServiceFactory() {

    }

    public static TweetServiceFactory getInstance(){
        return factory;
    }

    public TweetService getService() {
        return new TweetServiceImpl();
    }
}
