package com.akash.dao;

import com.akash.dao.impl.TweetDaoImpl;

public class TweetDaoFactory {

    private final static TweetDaoFactory dao = new TweetDaoFactory();

    private TweetDaoFactory(){

    }

    public static TweetDaoFactory getInstance(){
        return dao;
    }

    public TweetDaoImpl getDao(){
        return new TweetDaoImpl();
    }

}
