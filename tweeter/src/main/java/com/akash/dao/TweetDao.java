package com.akash.dao;

import com.akash.models.Pojo;

import java.util.List;

public interface TweetDao {

    String getMessage();

    void posted(String message);

    long putCache(List<Pojo> timeline, long expTimeInMillis);

    List<Pojo> getCache();

    void printMap();

}
