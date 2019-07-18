import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;


public class Config extends Configuration {

        @NotEmpty
        private String template;

        @NotEmpty
        private String consumerKey;

        @NotEmpty
        private String consumerSecret;

        @NotEmpty
        private String accessToken;

        @NotEmpty
        private String accessTokenSecret;

        @NotEmpty
        private String defaultName = "Stranger";

        @JsonProperty
        public String getConsumerKey() { return consumerKey; }

        @JsonProperty
        public String getConsumerSecret() {
            return consumerSecret;
        }


        @JsonProperty
        public String getAccessToken() {
            return accessToken;
        }

        @JsonProperty
        public String getAccessTokenSecret() {
        return accessTokenSecret;
    }


        @JsonProperty
        public String getTemplate() {
            return template;
        }

        @JsonProperty
        public void setTemplate(String template) {
            this.template = template;
        }

        @JsonProperty
        public String getDefaultName() {
            return defaultName;
        }

        @JsonProperty
        public void setDefaultName(String name) {
            this.defaultName = name;
        }
    }

