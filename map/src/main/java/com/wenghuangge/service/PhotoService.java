package com.wenghuangge.service;

import com.wenghuangge.bean.po.Photo;
import com.wenghuangge.bean.vo.PhotoMapVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName footmap
 * @ClassName PhotoService
 * @Date 2021/2/24 12:17
 * @Author wenghuangge
 * @Version 1.0
 */

public interface PhotoService {
    /**
     * 根据用户Id获取去过的地方
     * @param userId
     * @return
     */
    List <Photo> getMap(Integer userId);

    /***
     * 统计函数
     * @param userId 用户id
     * @param start_time 开始时间
     * @param end_time 结束时间
     * @return
     *  0.去过的省份数量
     *  1.去过的城市数量
     *  2.发过的照片数
     *  3.去过最多的省份
     *  4.去过最多的城市
     *  5.最经常去的省份中其中一张照片
     *  6.最新一次的照片
     *  7.最东方的照片
     *  8.最南边的照片
     *  9.最西边的照片
     *  10.最北边的照片
     *  最东南西北的省份 4个数据按顺序
     *  最东南西北的城市 4个数据按顺序
     *
     */
    List <Object> cal_palce(Integer userId,Long start_time,long end_time);

    /***
     * 用户记录足迹数量
     * @param userId
     * @return
     */
    int getNum(int userId);

    /***
     * 根据照片id获取照片信息
     * @param id
     * @return
     */
    Photo getPhotoById(int id);

    /**
     * 根据Id删除照片
     * @param id
     */
    void delete(int photoId,int userId);

    /**
     * 保存照片
     * @param photo
     */
    public void save(Photo photo);

    List<Photo> getPhotoByCity(int userId,String cityName);

    List<Photo> getVisitCity(int userId);


    List<Photo> getPhotoByProvince(int userId, String Province);
}
