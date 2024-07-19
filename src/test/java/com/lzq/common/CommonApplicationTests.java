package com.lzq.common;

import com.lzq.common.domain.po.SysUser;
import com.lzq.common.mapper.SysUserMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CommonApplicationTests {
    @Resource
    SysUserMapper sysUserMapper;
    @Test
    void contextLoads() {
        List<SysUser> sysUsers = sysUserMapper.selectList(null);
    }

}
