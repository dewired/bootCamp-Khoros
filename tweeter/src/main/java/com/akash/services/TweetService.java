package com.akash.services;

import twitter4j.Status;
import twitter4j.Twitter;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.List;

public interface TweetService {

    List<Status> getTweet(Twitter twitter);

    String postTweet(Twitter twitter, @DefaultValue("default") @QueryParam("message") String message);
}
