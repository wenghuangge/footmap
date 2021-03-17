package com.wenghuangge.controller;

import com.wenghuangge.context.MySessionContext;
import com.wenghuangge.mapper.PhotoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @ProjectName footmap
 * @ClassName ArticleController
 * @Date 2021/3/12 16:24
 * @Author wenghuangge
 * @Version 1.0
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    PhotoMapper photoMapper;
    @GetMapping("/detail")
    public void getArticleDetail(int id,String sessionInfo){

    }
}
