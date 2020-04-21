package com.aote.jds;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class JedisAPI {

    public static void main(String[] args) {
        String host = "127.0.0.1";
        Jedis jedis = new Jedis(host,6379);

        jedis.set("k1","v1");
        jedis.set("k2","v2");
        jedis.set("k3","v3");

        System.out.println(jedis.get("k1"));

        Set<String> sets = jedis.keys("*");
        System.out.println(sets);

    }

}
