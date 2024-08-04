package com.lzq.common.util;

import com.lzq.common.domain.po.SysUser;

/**
 * 保存用户信息到ThreadLocal的工具类
 */
public class UserHolderUtil {
    private UserHolderUtil() {
    }

    /**
     * ThreadLocal，存放用户对象
     */
    private static final ThreadLocal<SysUser> userHolder = new ThreadLocal<>();

    /**
     * 获取用户
     *
     * @return 用户对象
     */
    public static SysUser getUser() {
        return userHolder.get();
    }

    /**
     * 存放用户
     *
     * @param user 用户对象
     */
    public static void setUser(SysUser user) {
        userHolder.set(user);
    }

    /**
     * 释放ThreadLocal
     */
    public static void removeUser() {
        userHolder.remove();
    }
}
