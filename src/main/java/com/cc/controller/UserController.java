package com.cc.controller;

import com.cc.model.User;
import com.cc.service.SecurityService;
import com.cc.validator.UserValidator;
import com.cc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
    
    //For Registration Process
    
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
    	model.addAttribute("userForm", new User());
    	
    	return "registration";
    }
    
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
    	userValidator.validate(userForm, bindingResult);
    	
    	if (bindingResult.hasErrors()) {
    		return "registration";
    	}
    	
    	userService.saveUser(userForm);
    	
    	securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
    	
    	return "redirect:/welcome";
    }
    // For Login Process
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }
}
