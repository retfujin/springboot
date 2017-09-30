/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acec.demo.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author fujd
 */
@Controller
public class ThymeleafController {

    @RequestMapping("/hi")
    public String hello(Locale locale, Model model) {
        model.addAttribute("greeting", "Hello!");

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("currentTime", formattedDate);

        List ls = new ArrayList();
        Map map = new HashMap();
        map.put("id", "id1111");
        map.put("webLogo", "Logo1111");
        map.put("url", "http://www.sina.com.cn1111");
        map.put("title", "标题1111");
        map.put("description", "这个一个备注1111");
        ls.add(map);
        
        Map map2 = new HashMap();
        map2.put("id", "id2222");
        map2.put("webLogo", "Logo2222");
        map2.put("url", "http://www.sina.com.cn2222");
        map2.put("title", "标题2222");
        map2.put("description", "这个一个备注2222");
        ls.add(map2);
        
        model.addAttribute("collects", ls);
        return "hello";
    }
}
