package com.akash.models;

import java.util.Date;

public class Pojo {

    private String message;
    private String handle;
    private String name;
    private String profileImgUrl;
    private Date createdAt;

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

    public void setCreatedAt(Date createdAt){

        this.createdAt = createdAt;

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

    public Date getCreatedAt(){

        return createdAt;

   }


}
