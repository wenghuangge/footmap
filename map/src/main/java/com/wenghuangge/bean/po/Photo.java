package com.wenghuangge.bean.po;

import lombok.Data;

import java.util.List;

/**
 * @program: softwork-project
 * @description: 照片实体
 * @author: Yyf
 * @create:
 **/
@Data
public class Photo {

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
    /**
     * 上传成功or失败
     * 1：已上传
     * 0：未上传
     */
    private Byte visible;
    //时间戳转成字符串
    private String sTime;

}
