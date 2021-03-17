package com.wenghuangge.bean.vo;

import lombok.Data;

import java.util.ArrayList;

/**
 * @ProjectName footmap
 * @ClassName UserVO
 * @Date 2021/2/24 9:31
 * @Author wenghuangge
 * @Version 1.0
 */
@Data
public class UserVO {
    //用户Id
    private Integer userId;
    //去过的城市数量
    private Integer cityNum;
    //去过的省数量
    private Integer proNum;
    //成就
    private ArrayList<Integer> achievement;

}
