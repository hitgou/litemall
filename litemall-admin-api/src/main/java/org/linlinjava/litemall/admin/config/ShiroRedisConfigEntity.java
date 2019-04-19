package org.linlinjava.litemall.admin.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
// @PropertySource("classpath:config/redis.properties")
public class ShiroRedisConfigEntity {

    @Value("${shiro.redis.host}")
    private String host;

    @Value("${shiro.redis.timeout}")
    private int timeout;

    @Value("${shiro.redis.password}")
    private String password;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
