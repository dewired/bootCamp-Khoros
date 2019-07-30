package com.akash.resources;

import com.akash.cache.redisCache;
import com.akash.dao.TweetDao;
import com.akash.dao.TweetDaoFactory;
import com.akash.models.Pojo;
import com.akash.services.TweetService;
import com.akash.services.TweetServiceFactory;
import twitter4j.Twitter;

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

    public TweetResource(Twitter instance, long expTime) {

        twitter = instance;
        expTimeInMillis = expTime;
    }

    @Path("/tweets")
    @GET
    public Response getTwee() {

        if(expirationTime < System.currentTimeMillis()){
            List<Pojo> value = service.getTweet(twitter);;
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
        List<Pojo> value = service.filterTweet(twitter);;
        return Response.ok(value).build();
    }
    @Path("/post")
    @POST
    public String postTwee(String message){
        service.postTweet(twitter, message);
        return "Tweet posted";
    }
}
