package com.akash.services.impl;

import com.akash.models.Pojo;
import com.akash.services.TweetService;
import twitter4j.Status;
import twitter4j.Twitter;

import javax.ws.rs.core.Response;
import java.util.List;

public class TweetServiceImpl2 implements TweetService {

    @Override
    public List<Pojo> getTweet(Twitter twitter) {
        return null;
    }

    @Override
    public String postTweet(Twitter twitter, String message) {
        return null;
    }

    @Override
    public List<Pojo> filterTweet(Twitter twitter) {
        return null;
    }
}
