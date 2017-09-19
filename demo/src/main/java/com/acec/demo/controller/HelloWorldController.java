/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acec.demo.controller;

import com.acec.demo.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fujd
 */
@RestController
public class HelloWorldController {
    
    @RequestMapping("/hello")
    public String index() {
        return "Hello World XXX";
    }
    
    @RequestMapping("/getUser")
    public User getUser() {
    	User user=new User();
    	user.setUserName("小明");
    	user.setPassWord("xxxxxxx");
        return user;
    }
}
