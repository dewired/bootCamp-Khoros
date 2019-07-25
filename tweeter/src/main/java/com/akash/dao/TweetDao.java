package com.akash.dao;

import java.util.HashMap;

public interface TweetDao<message> {

    String getMessage();

    void posted(String message);

    void printMap();

}
