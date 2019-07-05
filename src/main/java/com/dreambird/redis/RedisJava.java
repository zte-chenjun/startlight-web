package com.dreambird.redis;

import com.mchange.v2.c3p0.ConnectionTester;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by chen.jun on 2018/2/23.
 */
public class RedisJava {

    public static void main(String[] args) {
        connectionTest();
//        jedisPool();
    }

    public static  void connectionTest(){
        //连接本地的 Redis 服务
//        Jedis jedis = new Jedis("localhost");
        Jedis jedis = new Jedis("8.8.8.8",6379);
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
        jedis.set("test","chenjun");
        System.out.println(jedis.get("test"));
        //释放资源
        jedis.close();
    }

    public static void jedisPool(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(30); //设置最大连接数
        config.setMaxIdle(10); //设置空闲连接数
        JedisPool pool = new JedisPool(config,"192.168.88.128",6379);
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            System.out.println(jedis.ping());
            jedis.set("name","zhangsan");
            System.out.println(jedis.get("name"));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (jedis != null){
                jedis.close();
                if (pool != null){
                    pool.close();
                }
            }
        }

    }

}
