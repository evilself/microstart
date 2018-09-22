package io.falcon.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

//@Configuration
public class RedisConfig {
//    @Bean
//    @Primary
//    JedisConnectionFactory jedisConnectionFactory() {
//        return new JedisConnectionFactory();
//    }
//
//    @Bean
//    @Autowired
//    public RedisTemplate<String, Object> redisTemplate(JedisConnectionFactory connectionFactory) {
//        RedisTemplate<String, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(con);
//        return template;
//    }
}