package com.yaoyue.cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 王东旭
 * @createTime 2022/3/15 9:41
 * @description 统一返回模板
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result implements Serializable {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 数据集
     */
    private String data;

    public Result(Integer code, String msg) {
        this(code, msg, null);
    }

    public static Result success() {
        return success(null);
    }

    public static Result fail() {
        return new Result(400, "操作失败");
    }

    public static Result success(String data) {
        return new Result(200, "操作成功", data);
    }
}
