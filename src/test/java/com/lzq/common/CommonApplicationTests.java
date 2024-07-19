package com.lzq.common;

import com.lzq.common.mapper.SysUserMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class CommonApplicationTests {
    @Resource
    SysUserMapper sysUserMapper;

    @Resource
    StringRedisTemplate stringRedisTemplate;

    @Resource
    RedisTemplate<String,Object> redisTemplate;

    @Test
    void contextLoads() {
        stringRedisTemplate.opsForValue();
        System.out.println(redisTemplate.opsForValue().get("name1"));
    }

}
