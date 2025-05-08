package com.example.spring.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.spring.mvc.service.ServiceUsers;

@Controller
@RequestMapping("/home")
public class UsersController {
	
	private static final Logger logger = LoggerFactory.getLogger(UsersController.class);
	
	@Autowired
	ServiceUsers serviceUsers;
	
	@RequestMapping(value = "/table-users", method = RequestMethod.GET)
	public String tableUsers(Model model) {
		logger.info("tableUsers");
		model.addAttribute("listUsers", serviceUsers.listUsers());
		return "home/table-users";
	
	}
	
	@RequestMapping(value = "/updateUsers", method = RequestMethod.GET)
	public String updateUsers(@RequestParam("usersId") int usersId, Model model) {
		logger.info("updateUsers");
		return "redirect:table-users";
	
	}
	
	@RequestMapping(value = "/deleteUsers", method = RequestMethod.GET)
	public String deleteUsers(@RequestParam("usersId") int usersId, Model model) {
		logger.info("deleteUsers");
		serviceUsers.deleteUsers(usersId);		
		return "redirect:table-users";
	
	}

}
