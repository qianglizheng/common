package com.lzq.common.util;

import com.lzq.common.enums.ReturnCodeEnum;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 1.构造方法私有化
 * 2.方法静态
 * @param <T>
 */

@Data
@Accessors(chain = true)
public final class ResultDataUtil<T> {
    /**
     * 响应码
     */
    private String code;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;

    /**
     * 响应时间
     */
    private long timestamp;

    private ResultDataUtil() {
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * 携带数据的成功返回
     *
     * @param <T> data
     * @return ResultDataUtil<T>
     */
    public static <T> ResultDataUtil<T> success(T data) {
        ResultDataUtil<T> result = new ResultDataUtil<>();
        result.setCode(ReturnCodeEnum.RC200.getCode());
        result.setMessage(ReturnCodeEnum.RC200.getMessage());
        result.setData(data);
        return result;
    }

    /**
     * 不携带数据的成功返回
     *
     * @return ResultDataUtil<T>
     */
    public static <T> ResultDataUtil<T> success() {
        ResultDataUtil<T> result = new ResultDataUtil<>();
        result.setCode(ReturnCodeEnum.RC200.getCode());
        result.setMessage(ReturnCodeEnum.RC200.getMessage());
        result.setData(null);
        return result;
    }

    /**
     * 自定义失败
     *
     * @param returnCodeEnum 返回枚举
     * @return ResultDataUtil
     */
    public static <T> ResultDataUtil<T> fail(ReturnCodeEnum returnCodeEnum) {
        ResultDataUtil<T> result = new ResultDataUtil<>();
        result.setCode(returnCodeEnum.getCode());
        result.setMessage(returnCodeEnum.getMessage());
        result.setData(null);
        return result;
    }

    /**
     * 默认使用RC400失败
     *
     * @return ResultDataUtil<T>
     */
    public static <T> ResultDataUtil<T> fail() {
        ResultDataUtil<T> result = new ResultDataUtil<>();
        result.setCode(ReturnCodeEnum.RC400.getCode());
        result.setMessage(ReturnCodeEnum.RC400.getMessage());
        result.setData(null);
        return result;
    }
}
