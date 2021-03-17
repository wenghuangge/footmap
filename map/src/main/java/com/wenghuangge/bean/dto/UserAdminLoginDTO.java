package com.wenghuangge.bean.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @ProjectName footmap
 * @ClassName UserAdminLoginDTO
 * @Date 2021/3/5 20:12
 * @Author wenghuangge
 * @Version 1.0
 */

@Data
@ApiModel(description = "管理员登录传输对象")
public class UserAdminLoginDTO  implements Serializable {
    @NotNull
    private String name;

    @NotNull
    private String pass;

    public UserAdminLoginDTO() {
    }
}
