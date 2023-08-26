package com.sky.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * 配置类, 创建RedisTemplate对象
 * @author awl
 * @date 2023/8/25 10:13
 */
@Configuration
@Slf4j
public class RedisConfiguration {

    /**
     * 引入的spring-boot-starter-data-redis会把连接工厂对象创建好, 放到spring容器中
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    @SuppressWarnings("all")
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        log.info("创建redis模板对象");
        RedisTemplate<String, Object> template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        //json序列化配置
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        //取objectmapper做转译器
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        //string序列化配置
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        //key采用string序列化配制
        template.setKeySerializer(stringRedisSerializer);
        //hash的key采用string序列化配制
        template.setHashKeySerializer(stringRedisSerializer);
        //value采用jackson序列化
//        template.setValueSerializer(jackson2JsonRedisSerializer);
        //hash的value采用jackson序列化配置
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        return template;


    }
}
