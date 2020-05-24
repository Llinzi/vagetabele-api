package com.vegetable.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : Result
 * @Description : controller接口返回的信息
 * @Author : 袁田婷
 * @Date: 2019-12-24 11:08
 */
public class Result extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public Result() {
        put("code", 0);
        put("msg", "success");
    }

    public static Result error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

    public static Result error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    /**
     * 返回错误信息
     * @param code 状态码
     * @param msg 错误信息
     * @return
     */
    public static Result error(int code, String msg) {
        Result r = new Result();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    /**
     * 返回正确信息
     * @param msg
     * @return
     */
    public static Result ok(String msg) {
        Result r = new Result();
        r.put("msg", msg);
        return r;
    }

    /**
     * 返回正确信息
     * @param map
     * @return
     */
    public static Result ok(Map<String, Object> map) {
        Result r = new Result();
        r.putAll(map);
        return r;
    }

    public static Result ok() {
        return new Result();
    }

    @Override
    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }


}
