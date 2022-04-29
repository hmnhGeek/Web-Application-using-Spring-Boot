package com.in28minutes.springboot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.in28minutes.springboot.web.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService _loginService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String showWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
		
		if(!_loginService.isValidUser(name, password)) {
			model.put("message", "Please enter correct credentials.");
			return "login";
		}
		
		model.put("display_name", name);
		model.put("display_password", password);
		return "welcome";
	}
}
