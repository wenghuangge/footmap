package com.wenghuangge.exceptijon.error;

public interface ApiError {

    // 获取异常信息
    String getMsg();

    // 获取异常代码
    Integer getCode();

}
