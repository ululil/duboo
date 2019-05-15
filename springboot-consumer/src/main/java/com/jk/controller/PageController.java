package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class PageController {

    @RequestMapping("query")
    public String query(){

        return "query";
    }


    @RequestMapping("login")
    public String login(){

        return "login";
    }
    @RequestMapping("toMain")
    public String toMain(){

        return "main";
    }
    @RequestMapping("findPower")
    public String powerList(){

        return "powerList";
    }


}
