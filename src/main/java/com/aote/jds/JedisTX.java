package com.aote.jds;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class JedisTX {

    public static void main(String[] args) {
        String host = "127.0.0.1";
        Jedis jedis = new Jedis(host,6379);

        Transaction transaction = jedis.multi();
        transaction.set("k4","v4");
        transaction.set("k5","v5");
        transaction.exec();

        System.out.println();
    }

    public boolean debt(Jedis jedis){
        int balance;
        int debt;
        int amtToSubtarct = 10;

        // watch监控，如果数据被修改则放弃事务
        jedis.watch("balance");
        balance = Integer.parseInt(jedis.get("balance"));
        if(balance <amtToSubtarct){
            jedis.unwatch();
            System.out.println("modify");
            return false;
        }else {
            System.out.println("transaction");
            Transaction transaction = jedis.multi();
            transaction.decrBy("balance",amtToSubtarct);
            transaction.incrBy("debt",amtToSubtarct);
            return true;
        }

    }


}
