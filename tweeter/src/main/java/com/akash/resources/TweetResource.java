package com.akash.resources;

import com.akash.Main;
import com.akash.cache.redisCache;
import com.akash.dao.TweetDao;
import com.akash.dao.TweetDaoFactory;
import com.akash.models.Pojo;
import com.akash.services.TweetService;
import com.akash.services.TweetServiceFactory;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("api/1.0/")
@Produces(MediaType.APPLICATION_JSON)
public class TweetResource {

    private Twitter twitter;
    TweetService service = TweetServiceFactory.getInstance().getService();
    long expirationTime = System.currentTimeMillis();
    long expTimeInMillis;
    TweetDao cache = TweetDaoFactory.getInstance().getDao();
    redisCache redis = new redisCache();

    @Inject
    private TweetService svc;


    @Inject
    public TweetResource(
            @Named("consumerKey") String consumerKey,
            @Named("consumerSecret") String consumerSecret,
            @Named("accessToken") String accessToken,
            @Named("accessTokenSecret") String accessTokenSecret,
            @Named("expTime") long expTimeInMillis) {

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey(consumerKey);
        cb.setOAuthConsumerSecret(consumerSecret);
        cb.setOAuthAccessToken(accessToken);
        cb.setOAuthAccessTokenSecret(accessTokenSecret);
        this.expTimeInMillis = expTimeInMillis;
        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter =  tf.getInstance();

    }

    @Path("/tweets")
    @GET
    public Response getTwee() {

        if(expirationTime < System.currentTimeMillis()){
            List<Pojo> value = svc.getTweet(twitter);;
            expirationTime = cache.putCache(value, expTimeInMillis);
            return Response.ok(value).build();
        }
        else
            return Response.ok(cache.getCache()).build();

    }

    @Path("/filter")
    @GET
    public Response filter() {

//        if(redis.getPojoList() == null){
//            redis.setPojoList(service.filterTweet(twitter));
//            return Response.ok(redis.getPojoList()).build();
//        }
//        else
//            return Response.ok(redis.getPojoList()).build();

//        List<Integer> list = redis.getLedgerList();
//        for (Integer l:list) {
//            System.out.println(l);
//        }
        List<Pojo> value = svc.filterTweet(twitter);
        return Response.ok(value).build();
    }
    @Path("/post")
    @POST
    public String postTwee(String message){
        svc.postTweet(twitter, message);
        return "Tweet posted";
    }
}
