package com.akash.services.impl;

import com.akash.dao.TweetDaoFactory;
import com.akash.dao.impl.TweetDaoImpl;
import com.akash.models.Pojo;
import com.akash.services.TweetService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.slf4j.LoggerFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TweetServiceImpl implements TweetService {

    List<Pojo> details = new ArrayList<>();
    TweetDaoImpl dao = TweetDaoFactory.getInstance().getDao();

    private static Logger logger = LogManager.getLogger(TweetServiceImpl.class);
    @Override
    public List<Pojo> getTweet(Twitter twitter) {

        logger.info("GET REQUEST INITIATED");

        try{
            System.out.println("hello get tweets from service 1");
            final List<Status> value = twitter.getHomeTimeline(new Paging());
            //System.out.println(value);
         //   Logger logger = LoggerFactory.getLogger(TweetServiceImpl.class);
            logger.error("An exception occurred!", new Exception("Custom exception"));
            SimpleDateFormat sdf = new SimpleDateFormat("MMMM d, yyyy 'at' h:mm a");
            for (Status status: value)
            {
                Pojo pojo = new Pojo();

                pojo.setMessage(status.getText());
                pojo.setHandle(status.getUser().getScreenName());
                pojo.setName(status.getUser().getName());
                pojo.setProfileImgUrl(status.getUser().getProfileImageURL());
                pojo.setCreatedAt(sdf.format(status.getCreatedAt()));
                String url= "https://twitter.com/" + status.getUser().getScreenName()
                        + "/status/" + status.getId();
                pojo.setLink(url);

                details.add(pojo);
            }
            return details;

        } catch (TwitterException e){
           List<Pojo> list = null ;
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

    @Override
    public List<Pojo> filterTweet(Twitter twitter) {

        List<Pojo> details = getTweet(twitter);
        List<Pojo> collect = details
                .stream()
                .filter(pojo -> pojo.getHandle().equals("ANI"))
                .map(pojo -> {
                    System.out.println(pojo.getMessage());
                    return pojo;
                })
                .collect(Collectors.toList());
        return collect;

    }

}
