package com.cest.core.redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * redis配置表 获取配置文件
 * Created by cestlavie on 2019/9/23.
 */
@Data
@Component
@ConfigurationProperties(prefix="redis")
public class RedisConfig {

    private String host;
    private int port;
    private int timeout;
    private String password;
    private int poolMaxTotal;
    private int poolMaxIdle;
    private int poolMaxWait;

}
