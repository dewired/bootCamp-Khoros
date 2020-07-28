package com.akash.models;

import java.util.Date;

public class Pojo {

    private String message;
    private String handle;
    private String name;
    private String profileImgUrl;
    private String createdAt;
    private String link;

// Setters

    public void setMessage(String message){

        this.message = message;

    }

    public void setHandle(String handle){

        this.handle = handle;

    }

    public void setName(String name){

        this.name = name;

    }

    public void setProfileImgUrl(String profileImgUrl){

        this.profileImgUrl = profileImgUrl;
    }

    public void setCreatedAt(String createdAt){

        this.createdAt = createdAt;

    }

    public void setLink(String link) {
        this.link = link;
    }

    // Getters

    public String getMessage(){

        return message;

   }

    public String getHandle(){

        return handle;

   }

    public String getName(){

        return name;

   }

    public String getProfileImgUrl(){

        return profileImgUrl;

   }

    public String getCreatedAt(){

        return createdAt;

   }

    public String getLink() {
        return link;
    }
}
