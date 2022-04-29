package com.in28minutes.springboot.web.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {
	public boolean isValidUser(String username, String password) {
		return username.equalsIgnoreCase("himanshu") && password.equalsIgnoreCase("password");
	}
}
