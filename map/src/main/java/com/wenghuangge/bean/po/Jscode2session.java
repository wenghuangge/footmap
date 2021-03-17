package com.wenghuangge.bean.po;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @ProjectName footmap
 * @description: 微信l临时登录凭证code换取的长期凭证
 * @ClassName Jscode2session
 * @Date 2021/3/5 20:44
 * @Author wenghuangge
 * @Version 1.0
 */

@Data
public class Jscode2session  implements Serializable {
    @JsonProperty("session_key")
    private String sessionKey;

    @JsonProperty("expires_in")
    private String expires_in;

    //用户唯一
    @JsonProperty("openid")
    private String openid;
}
