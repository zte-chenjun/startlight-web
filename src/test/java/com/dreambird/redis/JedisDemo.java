package com.dreambird.redis;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by chen.jun on 2018/3/13.
 */
public class JedisDemo {

    private Jedis jedis;

    @org.junit.Before
    public void connectionRedis(){
        jedis = new Jedis("localhost");
    }

    /**
     * redis存储字符串
     */
    @Test
    public void testString(){
        //添加数据
        jedis.set("name","张三");
        System.out.println(jedis.get("name"));

        //拼接数据
        jedis.append("name","好样的");
        System.out.println(jedis.get("name"));

        //删除数据
        jedis.del("name");
        System.out.println(jedis.get("name"));

        //设置多个键值对
        jedis.mset("name","张三","age","12","QQ","123456");
        jedis.incr("age");
        System.out.println("姓名："+jedis.get("name")+"  年龄："+jedis.get("age")+"  QQ:"+jedis.get("QQ"));
    }

    /**
     * redis操作Map
     */
    @Test
    public void testMap(){
        //-----添加数据----------
        Map<String,String> map = new HashMap<String,String>();
         map.put("name","张三");
         map.put("age","12");
         map.put("QQ","123456");
         jedis.hmset("user",map);
        //取出user中的name，执行结果:[minxr]-->注意结果是一个泛型的List
        //第一个参数是存入redis中map对象的key，后面跟的是放入map中的对象的key，后面的key可以跟多个，是可变参数
        List<String> resultMap = jedis.hmget("user","name","age","QQ");
        System.out.println(resultMap);

        //删除map中的某个键值
        jedis.hdel("user","age");
        System.out.println(jedis.hmget("user", "age")); //因为删除了，所以返回的是null
        System.out.println(jedis.hlen("user")); //返回key为user的键中存放的值的个数2
        System.out.println(jedis.exists("user"));//是否存在key为user的记录 返回true
        System.out.println(jedis.hkeys("user"));//返回map对象中的所有key
        System.out.println(jedis.hvals("user"));//返回map对象中的所有value

        //遍历redis中的Map
        Iterator<String> it = jedis.hkeys("user").iterator();
        while (it.hasNext()){
            String key = it.next();
            System.out.println(key);
            System.out.println(jedis.hmget("user",key));
        }
    }

    /**
     * jedis操作List
     */
    @Test
    public void testList(){
        //开始前先移除所有内容
        jedis.del("java framework");
        System.out.println(jedis.lrange("java framework",0,-1));

        //存放数据
        jedis.lpush("java framework","spring");
        jedis.lpush("java framework","struts");
        jedis.lpush("java framework","hibernate");
        //再取出所有数据jedis.lrange是按范围取出，
        // 第一个是key，第二个是起始位置，第三个是结束位置，jedis.llen获取长度 -1表示取得所有
        System.out.println(jedis.lrange("java framework",0,-1));

        jedis.del("java framework");
        jedis.rpush("java framework","spring");
        jedis.rpush("java framework","struts");
        jedis.rpush("java framework","hibernate");
        System.out.println(jedis.lrange("java framework",0,-1));



    }

}
