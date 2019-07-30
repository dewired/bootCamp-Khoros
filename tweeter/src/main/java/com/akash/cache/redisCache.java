package com.akash.cache;

import com.akash.models.Pojo;
import org.redisson.Redisson;
import org.redisson.api.LocalCachedMapOptions;
import org.redisson.api.RList;
import org.redisson.api.RLocalCachedMap;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class redisCache {

    RedissonClient client;

    RList<Pojo> pojoList;

    public redisCache() {
        Config redisConfig = new Config();
        redisConfig.useSingleServer().setAddress("redis://127.0.0.1:6379");
        client = Redisson.create(redisConfig);
    }


//    private List<Integer> lsit = new ArrayList<Integer>();
//    lsit.add(1);
//    lsit.add(2);
//    lsit.add(3);

    public List<Pojo> getPojoList(){

        return pojoList;
    }

    public void setPojoList(List<Pojo> pojos){
        pojoList = client.getList("pojoList");


        for (Pojo pojo: pojos
             ) {

            pojoList.add(pojo);

        }
    }


    public RList<Integer> getLedgerList() {
        RList<Integer> ledgerList = client.getList("ledgerList");
        ledgerList.add(1);
        ledgerList.add(2);
        ledgerList.add(3);
        ledgerList.add(4);
        ledgerList.add(5);
        return ledgerList;
    }
}
