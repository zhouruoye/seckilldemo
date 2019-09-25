package com.cest.core.redis.key;

/**
 * Created by cestlavie on 2019/9/25.
 */
public class SeckillUserKey extends BasePre {

    //默认两天
    public static final int TOKEN_EXPIRE = 60 * 60 * 24 * 2;

    public SeckillUserKey(int expireSeconds, String pre) {
        super(expireSeconds, pre);
    }

    public static SeckillUserKey token = new SeckillUserKey(TOKEN_EXPIRE,"token");
}
