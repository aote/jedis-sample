package com.aote.jds;

import redis.clients.jedis.Jedis;

public class JedisMS {

    public static void main(String[] args) {
        String host = "127.0.0.1";
        Jedis jedisM = new Jedis(host,6379);
        Jedis jedisS = new Jedis(host,6380);

        jedisM.set("class","1122");

        String result = jedisS.get("class");
        System.out.println(result);


    }

}
