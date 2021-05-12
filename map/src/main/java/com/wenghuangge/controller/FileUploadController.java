package com.wenghuangge.controller;

import com.wenghuangge.utils.FastDfsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public Map<String,Object> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        String realpath=fastDfsUtil.uploadFile(file);
        Map<String,Object> resultMap=new HashMap();
        resultMap.put("imgPath",realpath);
        return resultMap;
    }

}
