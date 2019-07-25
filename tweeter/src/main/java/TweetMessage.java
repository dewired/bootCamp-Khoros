import com.codahale.metrics.annotation.Timed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.conf.ConfigurationBuilder;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


interface getPost{

    void getTweets(Twitter twitter) throws TwitterException;
    String postTweet(Twitter twitter, String message) throws TwitterException;

        }




@Path("/tweet")
@Produces(MediaType.APPLICATION_JSON)
public class TweetMessage implements getPost{
    private Twitter twitter;
    private static Logger logger = LoggerFactory.getLogger(TweetMessage.class);
    serviceLayer s = new serviceLayer();

    //private String message = "Testing101";

    public TweetMessage(Twitter twitter){

        this.twitter = twitter;
    }

    @GET
    @Timed
    public void getTweets(Twitter twitter){
        s.getTweets(twitter);
    }


//            throws TwitterException {
//        final List<Status> value = twitter.getHomeTimeline(new Paging());
//        logger.error("An exception occurred!", new Exception("Custom exception"));
//        return Response.ok(value).build();
//    }

    @POST
    @Timed
    public String postTweet (Twitter twitter, String message) throws TwitterException{
        s.postTweet(twitter, message);
        return "Okay";
    }
//    public Response tweetMessage(@QueryParam("message") Optional<String> message) throws TwitterException {
//
//    }


}