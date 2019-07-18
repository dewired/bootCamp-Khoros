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

    public TweetMessage(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret){

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey(consumerKey);
        cb.setOAuthConsumerSecret(consumerSecret);
        cb.setOAuthAccessToken(accessToken);
        cb.setOAuthAccessTokenSecret(accessTokenSecret);
        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();
    }

    @GET
    @Timed
    public Response sayHello() throws TwitterException {
        final List<Status> value = twitter.getHomeTimeline(new Paging());
        return Response.ok(value).build();
    }

    @POST
    @Timed
    public void Something( @DefaultValue("ek ladki ko dekha toh aisa laga...") @QueryParam("message") String message) {
        try {
            twitter.updateStatus(message);
        } catch (TwitterException e) {
            return;
        }
    }
//    public Response tweetMessage(@QueryParam("message") Optional<String> message) throws TwitterException {
//
//    }
}