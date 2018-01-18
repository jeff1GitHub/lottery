package com.sf.lottery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

    @RequestMapping("")
    public ModelAndView getIndex(){
        return new ModelAndView("index");
    }

    @RequestMapping("login")
    public String getLogin(){
        return "login";
    }
}
