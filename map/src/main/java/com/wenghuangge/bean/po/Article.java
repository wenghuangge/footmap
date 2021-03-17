package com.wenghuangge.bean.po;

import lombok.Data;

import java.util.List;

/**
 * @ProjectName footmap
 * @ClassName Article
 * @Date 2021/3/12 19:43
 * @Author wenghuangge
 * @Version 1.0
 */

@Data
public class Article {
    private Integer id;

    private Integer userId;

    private Double longitude;

    private Double latitude;

    private String imgUrl;

    private List<String> imgList;

    private Long time;

    private Integer praiseNum;

    private String province;

    private String city;

    private String label;

    private String address;

    private Long photoTime;

    private String content;

    private String title;

    private String avatarUrl;
    
    /**
     * 上传成功or失败
     * 1：已上传
     * 0：未上传
     */
    private Byte visible;

}
