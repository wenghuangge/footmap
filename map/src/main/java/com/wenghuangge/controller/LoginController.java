package com.wenghuangge.controller;
import com.google.gson.JsonObject;
import org.json.JSONObject;
import com.wenghuangge.bean.po.Photo;
import com.wenghuangge.mapper.PhotoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/map")
public class LoginController {
    @Autowired
    private PhotoMapper photoMapper;
    @GetMapping("/map")
    public String map3(HttpServletRequest request,int userId) {
        List<Photo> photos = photoMapper.getAllByUserId(userId);
         //[{name:'北京'}, {name:'拉萨',value:50}],
        /*List<String> res=new ArrayList<>();
        List<String> res1=new ArrayList<>();
        String now="温州市";
        res.add(now);
        res1.add(now);
        for(int i=0;i<photos.size();i++){
            String city=photos.get(i).getCity();
            res.add(now);
            res1.add(city);
        }*/
        request.setAttribute("photos",photos);
        return "/map/map-test";

    }

}
