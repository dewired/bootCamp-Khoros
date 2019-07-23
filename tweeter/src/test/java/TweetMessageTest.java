import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import twitter4j.Status;
import twitter4j.Twitter;

import javax.ws.rs.core.Response;

import static junit.framework.TestCase.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TweetMessageTest {

    @Mock
    Twitter twitter;

    //Twitter twitter1 = Mockito.mock(Twitter.class);

    @Test
    public void TestMyApp() throws Exception{

        String message = "This is a test tweet";

        Status status = Mockito.mock(Status.class);

        Mockito.doReturn(status).when(twitter).updateStatus(message);

        TweetMessage tweetMessage = new TweetMessage(twitter);

        String R = tweetMessage.postTweet(message);

        Response get = tweetMessage.sayHello();

        assertEquals(get.getStatus(),200);


        //int stat = R.getStatus();
        //System.out.println(R.getStatus());

        //when(status.getText()).thenReturn(message);
//        boolean check;
//        if (stat == 200)    check = true;
//        else check = false;
//
        assertEquals(R, "Success");


    }
}
