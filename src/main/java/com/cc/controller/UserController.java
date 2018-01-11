package com.cc.controller;

import com.cc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Karla on 11-Jan-18.
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/select",method = RequestMethod.GET)
    public Map<String,String> select(){
//        userService.selectAll();
        HashMap<String,String> map = new HashMap<>();
        map.put("raspuns","dada");
        return map;
    }

}
