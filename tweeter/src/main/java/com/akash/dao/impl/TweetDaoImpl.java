package com.akash.dao.impl;

import com.akash.dao.TweetDao;
import com.akash.models.Pojo;

import java.util.HashMap;
import java.util.List;

public class TweetDaoImpl implements TweetDao {

    HashMap<String, String> data;
    List<Pojo> tweets;
    long expirationTime;

    public TweetDaoImpl() {
        data = new HashMap<>();
        data.put("toPost","res-ser-dao");
        data.put("posted",null);
    }


    @Override
    public String getMessage() {
        String msg = data.get("toPost");
        data.put("toPost",null);
        return msg;
    }

   @Override
    public long putCache(List<Pojo> timeline, long expTimeInMillis) {
        expirationTime = System.currentTimeMillis() + expTimeInMillis;
        tweets = timeline;
        return expirationTime;
    }

    @Override
    public List<Pojo> getCache() {

        return tweets;

    }

    @Override
    public void printMap() {

        data.entrySet().forEach(entry->{
            System.out.println(entry.getKey() + " " + entry.getValue());
        });

    }

    @Override
    public void posted(String message) {
        data.put("posted",message);
    }


}
