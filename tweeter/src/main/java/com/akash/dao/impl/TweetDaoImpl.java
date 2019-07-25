package com.akash.dao.impl;

import com.akash.dao.TweetDao;

import java.util.HashMap;

public class TweetDaoImpl implements TweetDao {

    HashMap<String, String> data;

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
