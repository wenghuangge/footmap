package com.wenghuangge.controller;

import com.wenghuangge.bean.po.Photo;
import com.wenghuangge.bean.po.User;
import com.wenghuangge.service.PhotoService;
import com.wenghuangge.service.UserService;
import io.lettuce.core.dynamic.annotation.Param;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    private int userId=0;
    @Autowired
    private PhotoService photoService;
    @Autowired
    private UserService userService;
    /**
     * 获取用户的全部照片
     * @param
     * @return
    **/

    @GetMapping("/map")
    public List<Photo> getMap(){
        getUser();
        List<Photo> list = photoService.getMap(userId);
        return list;

    }
    /**
     * 保存足迹
     * @param
     * @return
     **/

    @PostMapping("/save")
    public Boolean savePhoto(@RequestBody Photo photo){
        getUser();
        photo.setUserId(userId);
        photoService.save(photo);

        return true;

    }
    @GetMapping("/review")
    public List<Photo> review(@Param("start") Long start,@Param("end") Long end){
        getUser();
        List<Photo> list = photoService.review(userId,start,end);
        return list;

    }


    /***
     * 用户记录的足迹数量
     * @param userId
     * @return
     */
    @GetMapping("/num")
    public int getNum(int userId){
        getUser();
        return photoService.getNum(userId);
    }


    /***
     * 足迹的详细信息
     * @param id
     * @return
     */
    @GetMapping("/detail")
    public Photo photoDetail(int id){
        Photo photoById = photoService.getPhotoById(id);
        return photoById;
    }
    /***
     * 更新足迹
     * @param photo
     * @return
     */
    @PostMapping("/update")
    public void photoUpdate(@RequestBody Photo photo){
        photoService.photoUpdateById(photo);
    }

    /**
     * 根据足迹点id删除足迹
     * @param id
     * @return
     */
    @GetMapping("/delete")
    public void photoDelete(int id){

        getUser();
        photoService.delete(id, userId);
    }



    /***
     * 城市里的旅游足迹
     * @param cityname
     * @return
     */
    @GetMapping("/city")
    public List<Photo> getPhotosByCity(@RequestParam("cityname") String cityname){
        getUser();
        return photoService.getPhotoByCity(userId, cityname);
    }

    /***
     * 根据省份获取数据
     * @param province
     * @return
     */
    @GetMapping("/province")
    public List<Photo> getPhotosByProvince(@RequestParam("province") String province){
        getUser();
        return photoService.getPhotoByProvince(userId, province);
    }

    /***
     * 每个去过的城市的一张标签
     * @return
     */
    @CrossOrigin
    @GetMapping("/visitcity")
    public List<Photo> getVisitCity(){
        getUser();
        return photoService.getVisitCity(userId);
    }

    /***
     * 获取故事
     */
    @GetMapping("/count")
    public List<Object> getStory() {
        getUser();
        return photoService.cal_palce(userId,0L,999999999999999L);
    }
    public void getUser() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            if(currentUserName!=null&&currentUserName!="") {
                User user=userService.getUserByName(currentUserName);
                if(user!=null){
                    userId=user.getId();
                }
            }
        }
    }
}
