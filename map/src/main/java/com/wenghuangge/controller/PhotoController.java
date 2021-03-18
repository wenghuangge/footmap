package com.wenghuangge.controller;

import com.wenghuangge.bean.po.ApiResult;
import com.wenghuangge.bean.po.Photo;
import com.wenghuangge.bean.vo.PhotoMapVO;
import com.wenghuangge.service.PhotoService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName footmap
 * @ClassName PhotoController
 * @Date 2021/2/24 12:15
 * @Author wenghuangge
 * @Version 1.0
 */

@Slf4j
@Validated
@RestController
@RequestMapping("/photo")
public class PhotoController {
    private int userId=46;
    @Autowired
    private PhotoService photoService;

    /**
     * 获取用户的全部照片
     * @param userId
     * @return
    **/

    @GetMapping("/map")
    public ApiResult<Map> getMap(Integer userId){
        List<PhotoMapVO> list = photoService.getMap(userId);
        Map<String,Object> map=new HashMap<>();
        ApiResult<Map> result=new ApiResult<>();
        result.setStatus(0);
        map.put("data",list);
        result.setData(map);
        return result;

    }
    /**
     * 统计用户去过的地方，生成故事
     **/
    @GetMapping("/count")
    public ApiResult<Map> count(@RequestParam(required = false,defaultValue = "0") Long start_Time,@RequestParam(required = false,defaultValue = "99999999999999") Long end_Time,Integer userId){
        List<Object> res=photoService.cal_palce(userId, start_Time, end_Time);
        ApiResult<Map> apiResult=new ApiResult<>();
        apiResult.setStatus(0);
        Map <String,Object> map=new HashMap<>();
        map.put("data",res);
        apiResult.setData(map);
        return apiResult;
    }

    /***
     * 用户记录的足迹数量
     * @param userId
     * @return
     */
    @GetMapping("/num")
    public int getNum(int userId){
        return photoService.getNum(userId);
    }

    /***
     * 足迹的详细信息
     * @param id
     * @return
     */
    @PostMapping("/detail")
    public ApiResult<Map> photoDetail(int id){
        ApiResult<Map> result=new ApiResult<>();
        Map<Object,Object> map=new HashMap<>();
        Photo photoById = photoService.getPhotoById(id);
        map.put("data", photoById);
        result.setStatus(0);
        result.setData(map);
        return result;
    }

    /**
     * 根据足迹点id删除足迹
     * @param id
     * @return
     */
    @PostMapping("/delete")
    public ApiResult<Map> photoDelete(int id,int userId){
        ApiResult<Map> result=new ApiResult<>();
        Map<Object,Object> map=new HashMap<>();
        photoService.delete(id, userId);
        result.setStatus(0);
        result.setData(map);
        return result;
    }

    /**
     * 保存足迹
     * @param photo
     * @return
     */
    @PostMapping("/save")
    public ApiResult<Map> photoSave(@RequestBody Photo photo) {
        ApiResult<Map> apiResult=new ApiResult<>();
        photoService.save(photo);
        apiResult.setStatus(0);
        return apiResult;
    }

    @GetMapping("/city")
    public List<Photo> getPhotosByCity(@RequestParam("cityname") String cityname){
        return photoService.getPhotoByCity(userId, cityname);
    }
}
