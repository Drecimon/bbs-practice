package cn.ljlin233.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import redis.clients.jedis.JedisPoolConfig;

/**
 * RedisConfig
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisConnectionFactory redisCF() {
        JedisConnectionFactory cf = new JedisConnectionFactory();
        cf.setHostName("127.0.0.1");
        cf.setPort(6379);

        JedisPoolConfig poolConfig = new JedisPoolConfig();
        // 最大空闲数
        poolConfig.setMaxIdle(300);
        // 最大连接数
        poolConfig.setMaxTotal(100);
        // 最大等待时间
        poolConfig.setMaxWaitMillis(10000);

        cf.setPoolConfig(poolConfig);
        cf.afterPropertiesSet();
        return cf;
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory cf) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(cf);
        // keySerializer
        // valueSerializer

        return stringRedisTemplate;
    }
    
}