package com.akash.services.impl;

import com.akash.dao.TweetDaoFactory;
import com.akash.dao.impl.TweetDaoImpl;
import com.akash.services.TweetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.List;

public class TweetServiceImpl implements TweetService {

    TweetDaoImpl dao = TweetDaoFactory.getInstance().getDao();

    @Override
    public List<Status> getTweet(Twitter twitter) {
        try{
            System.out.println("hello get tweets");
            final List<Status> value = twitter.getHomeTimeline(new Paging());
            System.out.println(value);
            Logger logger = LoggerFactory.getLogger(TweetServiceImpl.class);
         //   logger.error("An exception occurred!", new Exception("Custom exception"));
           return value ;
        } catch (TwitterException e){
           List<Status> list = null ;
           return list ;
        }
    }


    @Override
    public String postTweet(Twitter twitter, @DefaultValue("default") @QueryParam("message")String message){
        dao.printMap();
        message = dao.getMessage();
        try {
            Status statusupdate = twitter.updateStatus(message);
            dao.posted(message);
            dao.printMap();
            return "Success";

        } catch (TwitterException e) {
            return "Exception";
        }

    }

}
