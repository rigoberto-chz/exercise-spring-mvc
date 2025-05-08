package com.example.spring.mvc.controller.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.spring.mvc.model.LoginVO;
import com.example.spring.mvc.model.RegisterVO;
import com.example.spring.mvc.service.ServiceLogin;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
			
	@Autowired
	ServiceLogin serviceLogin;
		
	@RequestMapping(value = {"/home/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
		logger.info("welcome");
        return "home/index";
    }

	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@Validated LoginVO loginVO, Model model) {
		logger.info("login");
		serviceLogin.login(loginVO);
		
		if(loginVO.getMessage().equalsIgnoreCase("logon")) {
			model.addAttribute("login", loginVO);
			return "home/index";
		} else if(loginVO.getMessage().equalsIgnoreCase("error")) {
			model.addAttribute("login", loginVO);
			model.addAttribute("error", "La contraseña es incorrecta.");
			return "login/login";
		} if(loginVO.getMessage().equalsIgnoreCase("register")) {
			RegisterVO registerVO = new RegisterVO();
			registerVO.setEmail(loginVO.getEmail());
			model.addAttribute("registerVO", registerVO);
			model.addAttribute("message", "Favor de registrar la cuenta.");
			return "register/register";
		} 
		
		return "login/login";
	}
	
}
