package com.xu.controller;


import org.springframework.stereotype.Controller;    
   
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//home“≥√Ê
@Controller    
public class LoginController {    
    
    @RequestMapping(value="/login.do")    
    public ModelAndView home_jsp(){ 
        ModelAndView mav = new ModelAndView("login");
//        mav.addObject("welcome","Hello"+ "£¨please write your name,then click save.");
		return mav;
    }    
}   
