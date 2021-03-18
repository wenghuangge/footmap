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

@RestController
@RequestMapping("/map")
public class LoginController {
    private int userId=46;
    @Autowired
    private PhotoMapper photoMapper;
    @GetMapping("/map")
    public List<Photo> map() {
        List<Photo> photos = photoMapper.getAllByUserId(userId);
        return photos;

    }

}
