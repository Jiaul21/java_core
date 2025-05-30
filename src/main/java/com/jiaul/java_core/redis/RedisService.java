package com.jiaul.java_core.redis;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    public <T> T get(String key, Class<T> entityClass) {
        try {
            Object obj = redisTemplate.opsForValue().get(key);
            return objectMapper.readValue(obj.toString(), entityClass);
        } catch (Exception e) {
            log.error("Redis get Exception: ", e.getMessage());
        }
        return null;
    }

    public void set(String key, Object obj, Long ttl) {
        try {
            String jsonValue = objectMapper.writeValueAsString(obj);
            redisTemplate.opsForValue().set(key, jsonValue, ttl, TimeUnit.SECONDS);
        } catch (Exception e) {
            log.error("Redis set Exception: ", e.getMessage());
        }
    }

    public boolean delete(String key) {
        try {
            redisTemplate.delete(key);
            return true;
        } catch (Exception e) {
            log.error("Redis delete Exception: ", e.getMessage());
        }
        return false;
    }
}
