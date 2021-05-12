package com.wenghuangge.mapper;

import com.wenghuangge.bean.po.Photo;
import io.lettuce.core.dynamic.annotation.Param;
import java.util.List;

/**
 * @ProjectName footmap
 * @ClassName PhotoMapper
 * @Date 2021/2/24 10:02
 * @Author wenghuangge
 * @description:照片mapper
 * @Version 1.0
 */

public interface PhotoMapper {
    void save(Photo photo);

    void updateVisible(@Param("photoId") Integer photoId, @Param("visible") Byte visible);

    Photo getById(@Param("id") Integer id);

    List<Photo> getAllByUserId(@Param("userId") Integer userId);

    List<Photo> review(@Param("userId") Integer userId,@Param("start") Long start,@Param("end") Long end);

    void updateById(Photo photo, @Param("userId") Integer userId);
    
    
    void delete(@Param("photoId") Integer photoId, @Param("userId") Integer userId);

    List<Photo> getByCity(@Param("userId") Integer userId,@Param("city") String city);

    List<Photo> getByProvince(@Param("userId") Integer userId,@Param("province") String province);

    void photoUpdateById(Photo photo);
}
