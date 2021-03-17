package com.wenghuangge.bean.po;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @ProjectName footmap
 * @ClassName WechatError
 * @Date 2021/3/5 20:59
 * @Author wenghuangge
 * @Version 1.0
 */
@Data
public class WechatError implements Serializable {

    @JsonProperty("errcode")
    private Integer errcode;

    @JsonProperty("errmsg")
    private String errmsg;

    public WechatError() {
    }
}