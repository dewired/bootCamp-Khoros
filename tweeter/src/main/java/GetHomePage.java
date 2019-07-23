import com.codahale.metrics.annotation.Timed;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class GetHomePage {


    private Twitter twitter;

    public GetHomePage(Twitter instance) {

        twitter = instance;
        //this.twitter.setOAuthConsumer(instance.get);

    }

    @GET
    @Timed
    public Response sayHello() throws TwitterException {
        final List<Status> value = twitter.getHomeTimeline(new Paging());
        return Response.ok(value).build();
    }

    @POST
    @Timed
    public void TweetMessage(String tweet) {
        String message = "Hello";
        try {
            twitter.updateStatus(tweet);
        } catch (TwitterException e) {
            return;
        }
    }
}