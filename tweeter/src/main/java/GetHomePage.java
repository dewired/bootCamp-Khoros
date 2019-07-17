import com.codahale.metrics.annotation.Timed;
import twitter4j.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class GetHomePage {

    private Twitter twitter = TwitterFactory.getSingleton();

    public GetHomePage() {
    }

    @GET
    @Timed
    public Response sayHello(@QueryParam("name") Optional<String> name) throws TwitterException {
        final List<Status> value = twitter.getHomeTimeline(new Paging());
        return Response.ok(value).build();
    }

    @POST
    @Timed
    public void TweetMessage() {
        String message = "Hello";
        try {
            twitter.updateStatus(message);
        } catch (TwitterException e) {
            return;
        }
    }
}