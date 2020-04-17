package com.yan.controller;

import com.yan.service.EsContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author: yan
 * @Date: 2020/4/17 19:29
 * @Description: com.yan.controller
 * @version: 1.0
 */
@RestController
public class ESContentController {

    @Autowired
    EsContentService esContentService;

    @GetMapping("/parse/{keywords}")
    public Boolean parse(@PathVariable("keywords") String keywords){
        try {
            return esContentService.parseContent(keywords);
        } catch (Exception e) {
            throw new RuntimeException("服务端错误o(╥﹏╥)o");
        }
    }
    @GetMapping("/search/{keywords}/{pageNo}/{pageSize}")
    public List<Map<String,Object>> search(@PathVariable("keywords") String keywords,
                                           @PathVariable("pageNo") Integer pageNo,
                                           @PathVariable("pageSize") Integer pageSize){

        try {
            return esContentService.searchRequest(keywords,pageNo,pageSize);
        } catch (Exception e) {
            throw new RuntimeException("服务端错误o(╥﹏╥)o");
        }
    }
}
