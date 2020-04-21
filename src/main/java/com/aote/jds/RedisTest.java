package com.aote.jds;

import redis.clients.jedis.Jedis;

public class RedisTest {

    public static void main(String[] args) {
        String host = "127.0.0.1";
        Jedis jedis = new Jedis(host,6379);
        System.out.println(jedis.ping());
    }

}
