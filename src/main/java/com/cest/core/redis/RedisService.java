package com.cest.core.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 操作redis 数据库
 * Created by cestlavie on 2019/9/23.
 */
@Service
public class RedisService {

    @Autowired
    private JedisPool jedisPool;

    /**
     * 获取当前对象
     * @param key
     * @param <T>
     * @return
     */
    public <T> T get(String key,Class<T> tClass){
        Jedis resource = null;
        try {
            resource = jedisPool.getResource();
            String str = resource.get(key);
            if(str == null || str.length() <= 0){
                return null;
            }

            return stringToBean(str,tClass);

        } finally {
            closeJedis(resource);
        }
    }

    /**
     * 设置对象
     * @param key
     * @param t
     * @param <T>
     * @return
     */
    public <T> boolean set(String key,T t){
        Jedis resource = null;
        try {
            resource = jedisPool.getResource();
            String str = beanToString(t);
            if(str == null || str.length() <= 0){
                return false;
            }
            resource.set(key, str);
            return true;
        } finally {
            closeJedis(resource);
        }
    }

    /**
     * 判断对象是否存在
     * @param key
     * @param <T>
     * @return
     */
    public <T> boolean isExists(String key){
        Jedis resource = null;
        try {
            resource = jedisPool.getResource();
            return resource.exists(key);
        } finally {
            closeJedis(resource);
        }
    }

    /**
     * bean 转 String
     * @param value
     * @param <T>
     * @return
     */
    private <T> String beanToString(T value) {
        if(value == null) {
            return null;
        }
        Class<?> clazz = value.getClass();
        if(clazz == int.class || clazz == Integer.class) {
            return ""+value;
        }else if(clazz == String.class) {
            return (String)value;
        }else if(clazz == long.class || clazz == Long.class) {
            return ""+value;
        }else {
            return JSON.toJSONString(value);
        }
    }

    /**
     * String 转 bean
     * @param str
     * @param clazz
     * @param <T>
     * @return
     */
    private <T> T stringToBean(String str, Class<T> clazz) {
        if(str == null || str.length() <= 0 || clazz == null) {
            return null;
        }
        if(clazz == int.class || clazz == Integer.class) {
            return (T)Integer.valueOf(str);
        }else if(clazz == String.class) {
            return (T)str;
        }else if(clazz == long.class || clazz == Long.class) {
            return  (T)Long.valueOf(str);
        }else {
            return JSON.toJavaObject(JSON.parseObject(str), clazz);
        }
    }

    public void closeJedis(Jedis jedis){
        jedis.close();
    }
}
