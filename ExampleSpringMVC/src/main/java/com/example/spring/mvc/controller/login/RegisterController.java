package com.example.spring.mvc.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.spring.mvc.model.RegisterVO;
import com.example.spring.mvc.service.ServiceRegister;

@Controller
public class RegisterController {
	
	@Autowired
	ServiceRegister serviceRegister;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model) {
		return "register/register";
	}
	
	@RequestMapping(value = "/register-add", method = RequestMethod.POST)
	public String registerAdd(@Validated RegisterVO registerVO, Model model) {
		
		if(registerVO.getPassword().equals(registerVO.getRepeat())) {
			model.addAttribute("message", "Se registró correctamente.");
			serviceRegister.register(registerVO);
			return "login/login";
		} else {
			model.addAttribute("registerVO", registerVO);
			model.addAttribute("error", "La contraseña no coincide.");
			return "register/register";
		}
		
	}
}
