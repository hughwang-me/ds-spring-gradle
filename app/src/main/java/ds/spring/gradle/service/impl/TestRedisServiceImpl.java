package ds.spring.gradle.service.impl;

import ds.spring.gradle.service.TestRedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

//@DependsOn("springRedisConfig")
@Service
@Slf4j
public class TestRedisServiceImpl implements TestRedisService {

//    @Qualifier("redisTemplate")
    private RedisTemplate<String , String> redisTemplate;

    @Autowired
    public TestRedisServiceImpl(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void add(String key, String value) {
        redisTemplate.opsForValue().set(key , value);
    }

    @Override
    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
