package com.wenghuangge.bean.vo;

import lombok.Data;

import java.util.List;

/**
 * @ProjectName footmap
 * @ClassName PhotoMapVO
 * @Date 2021/2/24 12:18
 * @Author wenghuangge
 * @Version 1.0
 */
@Data
public class PhotoMapVO {
    private Integer id;

    private String imgUrl;

    private List<String> imgList;

    private Double longitude;

    private Double latitude;

    private String province;

    private String city;

    private String content;

    private String address;

    private Long time;



    private String title;
}
