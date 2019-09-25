package com.cest.core.redis.key;

/**
 * 组合模式 redis
 * Created by cestlavie on 2019/9/25.
 */
public interface KeyPre {

    //过期时间
    int expireSeconds();

    //前缀
    String getPre();
}
