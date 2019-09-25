package com.cest.core.redis.key;

/**
 * Created by cestlavie on 2019/9/25.
 */
public abstract class BasePre implements KeyPre {

    private int expireSeconds;

    private String pre;

    public BasePre(String pre) {
        this(0,pre);
    }

    public BasePre(int expireSeconds, String pre) {
        this.expireSeconds = expireSeconds;
        this.pre = pre;
    }

    @Override
    public int expireSeconds() {
        return expireSeconds;
    }

    @Override
    public String getPre() {
        return pre;
    }
}
