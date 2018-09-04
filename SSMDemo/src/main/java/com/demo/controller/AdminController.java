package com.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.User;
import com.demo.service.UserService;
 
@Controller
public class AdminController {
 
	@Autowired
	private UserService userService;
	
    @RequestMapping(value="index")
    public ModelAndView index(User user,HttpServletRequest req){
    	HttpSession session = req.getSession();
    	userService.insertUser(user);
    	session.setAttribute("loginuser", user);
        ModelAndView mav=new ModelAndView();
        mav.setViewName("index");
        mav.addObject("user",user);
        return mav;
    }
    
    @RequestMapping(value="admin")
    public ModelAndView admin(User user,HttpServletRequest req){
    	HttpSession session = req.getSession();
    	userService.insertUser(user);
    	session.setAttribute("loginuser", user);
        ModelAndView mav=new ModelAndView();
        mav.setViewName("index");
        mav.addObject("user",user);
        return mav;
    }
}