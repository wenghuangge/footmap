package com.wenghuangge.controller;

import com.wenghuangge.config.FastDfsConfig;
import com.wenghuangge.utils.FastDfsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @ProjectName footmap
 * @ClassName FileUploadController
 * @Date 2021/3/13 17:59
 * @Author wenghuangge
 * @Version 1.0
 */
@RestController
@RequestMapping("/file")
public class FileUploadController {
    @Autowired
    private FastDfsUtil fastDfsUtil;

    /***
     *
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping("/upload")
    public String uploadFile(MultipartFile file) throws IOException {
        String realpath=fastDfsUtil.uploadFile(file);
        return realpath;
    }
}
