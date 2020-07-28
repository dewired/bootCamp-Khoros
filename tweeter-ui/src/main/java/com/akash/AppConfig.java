package com.akash;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;


public class AppConfig extends Configuration {

    @NotEmpty
    private String consumerKey;

    @NotEmpty
    private String consumerSecret;

    @NotEmpty
    private String accessToken;

    @NotEmpty
    private String accessTokenSecret;

    @NotNull
    private long expTime;


    @JsonProperty
    public String getConsumerKey() {
        return consumerKey;
    }

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
    public long getExpTime() {
        return expTime;
    }


}

