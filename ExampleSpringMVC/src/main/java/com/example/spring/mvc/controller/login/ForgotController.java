package com.example.spring.mvc.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ForgotController {

	@RequestMapping(value = "/forgot", method = RequestMethod.GET)
	public String login(Model model) {
		return "forgot/forgot-password";
	}
	
}
