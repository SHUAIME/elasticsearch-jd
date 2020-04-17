package com.yan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: yan
 * @Date: 2020/4/17 18:14
 * @Description: com.yan.controller
 * @version: 1.0
 */
@Controller
public class Indexcontroller {
    @GetMapping({"/","/index"})
    public String index(){
        return "index";
    }
}
