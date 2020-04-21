package com.aote.jds;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class TestPool {


    public static void main(String[] args) {
        JedisPool jedisPool = JedisPoolUtil.getJedisPoolInstance();

        try {
            Jedis jedis = null;
            jedis = jedisPool.getResource();
            jedis.set("p1","v1");
        } catch (Exception e){

        } finally {
            //释放资源
            // jedis....
        }



    }

}
