import com.codahale.metrics.annotation.Timed;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/tweets")
@Produces(MediaType.APPLICATION_JSON)
public class TweetMessage {
    private Twitter twitter = TwitterFactory.getSingleton();

    private String message = "Testing101";

    public TweetMessage(){

    }

    @POST
    @Timed
    public void Something() {
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