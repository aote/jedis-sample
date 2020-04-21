package com.aote.jds;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * jedis连接池
 */
public class JedisPoolUtil {

    private static volatile JedisPool jedisPool = null;

    private JedisPoolUtil(){}

    public  static JedisPool getJedisPoolInstance(){
        if(null == jedisPool){
            synchronized (JedisPoolUtil.class){
                if(null == jedisPool){
                    JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
                    jedisPoolConfig.setMaxTotal(1000);
                    jedisPoolConfig.setMaxIdle(32);
                    jedisPoolConfig.setMaxWaitMillis(1000*1000);
                    jedisPoolConfig.setTestOnBorrow(true);
                    String host = "127.0.0.1";
                    jedisPool = new JedisPool(jedisPoolConfig,host,6379);
                }
            }
        }
        return jedisPool;
    }

    // 释放jedis资源 （不知道是不是getResource方法）
    public static void release(JedisPool jedisPool,Jedis jedis){
        if (null != jedisPool){
//            jedisPool.
        }
    }

}
