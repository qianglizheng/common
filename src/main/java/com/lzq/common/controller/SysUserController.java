package com.lzq.common.controller;

import com.lzq.common.domain.po.SysUser;
import com.lzq.common.service.SysUserService;
import com.lzq.common.util.ResultDataUtil;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SysUserController {

    @Resource
    private SysUserService sysUserService;


    @GetMapping("/list")
    public ResultDataUtil<List<SysUser>> list(){
        return ResultDataUtil.success(sysUserService.list());
    }

    @GetMapping("/test")
    public ResultDataUtil<List<SysUser>> test(){
        throw new RuntimeException("cuow ");
    }
}
