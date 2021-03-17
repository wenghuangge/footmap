package com.wenghuangge.bean.dto;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @ProjectName footmap
 * @ClassName UserOAuthDTO
 * @Date 2021/3/5 19:54
 * @Author wenghuangge
 * @Version 1.0
 */
@Data
@ApiModel("授权注册传输对象")
public class UserOAuthDTO implements Serializable {

    @NotNull
    @Size(min=1)
    @ApiModelProperty(required = true,name = "短期凭证code",example = "061xAqJa2YfIcP0KQZHa29pvJa2xAqJK")
    private String code;

    @NotNull
    @Size(min=1)
    @ApiModelProperty(required = true,name = "用户加密数据",example = "adf5e654ef123")
    private String encryptedData;

    @NotNull
    @Size(min=1)
    @ApiModelProperty(required = true,name = "iv字符串",example = "ZNt76BcMNcyiZ3q1T62w")
    private String ivStr;

}
