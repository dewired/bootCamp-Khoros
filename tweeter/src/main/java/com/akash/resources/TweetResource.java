package com.akash.resources;

import com.akash.services.TweetService;
import com.akash.services.TweetServiceFactory;
import twitter4j.Status;
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

    public TweetResource(Twitter instance) {

        twitter = instance;

    }

    @Path("/tweets")
    @GET
    public Response getTwee() {
        List<Status> value = service.getTweet(twitter);;
        return Response.ok(value).build();
    }


    @Path("/post")
    @POST
    public String postTwee(String message){
        service.postTweet(twitter, message);
        return "Tweet posted";
    }
}
