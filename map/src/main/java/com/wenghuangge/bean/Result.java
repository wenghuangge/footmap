package com.wenghuangge.bean;

/**
 * @ProjectName footmap
 * @ClassName Result
 * @Date 2021/2/19 18:46
 * @Author wenghuangge
 * @Version 1.0
 */

/**
 * 向前段返回封装信息
 */
public class Result<T> {
    //返回信息
    private String msg;

    /**
     * 数据是否正常请求
     */
    private boolean success;
    /**
     * 具体返回的数据
     */
    private T detail;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getDetail() {
        return detail;
    }

    public void setDetail(T detail) {
        this.detail = detail;
    }
}
