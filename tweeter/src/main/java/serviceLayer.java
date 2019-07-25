import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.*;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.List;

public class serviceLayer {


    public Response getTweets(Twitter twitter){
        try{
            final List<Status> value = twitter.getHomeTimeline(new Paging());
            Logger logger = LoggerFactory.getLogger(TweetMessage.class);
            logger.error("An exception occurred!", new Exception("Custom exception"));
            return Response.ok(value).build();
        } catch (TwitterException e){

        }
        return Response.ok().build();
    }

    public String postTweet(Twitter twitter, @DefaultValue("default") @QueryParam("message")String message){

        try {
            Status statusupdate = twitter.updateStatus(message);
            return "Success";

        } catch (TwitterException e) {
            return "Exception";
        }

    }

}
