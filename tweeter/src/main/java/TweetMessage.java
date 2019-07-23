import com.codahale.metrics.annotation.Timed;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/tweet")
@Produces(MediaType.APPLICATION_JSON)
public class TweetMessage {
    private Twitter twitter;

    //private String message = "Testing101";

    public TweetMessage(Twitter twitter){

        this.twitter = twitter;
    }

    @GET
    @Timed
    public Response sayHello() throws TwitterException {
        final List<Status> value = twitter.getHomeTimeline(new Paging());
        return Response.ok(value).build();
    }

    @POST
    @Timed
    public String postTweet (@DefaultValue("default") @QueryParam("message") String message) throws TwitterException{
//        try {
            Status statusupdate = twitter.updateStatus(message);
            return "Success";

//        } catch (TwitterException e) {
//            return "Exception";
//        }
    }
//    public Response tweetMessage(@QueryParam("message") Optional<String> message) throws TwitterException {
//
//    }


}