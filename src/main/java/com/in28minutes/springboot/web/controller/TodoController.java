package com.in28minutes.springboot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.in28minutes.springboot.web.service.LoginService;
import com.in28minutes.springboot.web.service.TodoService;

@Controller
@SessionAttributes({"display_name"})
public class TodoController {
	
	@Autowired
	TodoService _todoService;
	
	@RequestMapping(value="/list-todos", method=RequestMethod.GET)
	public String showTodos(ModelMap model) {
		String name = (String)model.get("display_name");
		System.out.println(name);
		model.put("todos", _todoService.retrieveTodos(name));
		return "list-todos";
	}
}
