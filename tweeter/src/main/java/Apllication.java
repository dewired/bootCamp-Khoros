import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


public class Apllication extends Application<Configuration> {

    public static void main(String[] args) throws Exception {
        new Apllication().run(args);
    }

//    @Override
//    public String getName() {
//        return "hello-world";
//    }

    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(Configuration configuration,
                    Environment environment) {
        final GetHomePage resource = new GetHomePage();
        final TweetMessage tweeter = new TweetMessage();
        environment.jersey().register(resource);
        environment.jersey().register(tweeter);
    }
}