package com.wenghuangge.bean.po;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @ProjectName footmap
 * @ClassName WechatUser
 * @Date 2021/3/5 20:22
 * @Author wenghuangge
 * @Version 1.0
 */
@Data
//忽略垃圾字段
@JsonIgnoreProperties(ignoreUnknown = true)
public class WechatUser implements Serializable {
    @JsonProperty("userId")
    private Integer userId;

    @JsonProperty("country")
    private String country;

    @JsonProperty("gender")
    private Integer gender;

    @JsonProperty("province")
    private String province;

    @JsonProperty("city")
    private String city;

    @JsonProperty("avatarUrl")
    private String avatarUrl;

    @JsonProperty("openId")
    private String openId;

    @JsonProperty("sessionId")
    private String sessionId;

    @JsonProperty("language")
    private String language;

    @JsonProperty("createTime")
    private Long createTime;

    public WechatUser() {
    }
}
