package com.socket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class baseController {
    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }
}
