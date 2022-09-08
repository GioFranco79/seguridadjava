package com.edutecno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edutecno.model.Users;
import com.edutecno.services.UserService;


@Controller
public class RegisterController {
	@Autowired
	private UserService userService;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	@RequestMapping("/registrarse")
	public ModelAndView login() {
			return new ModelAndView("registration");		
	}
	
	@PostMapping("/registrarte")
	public ModelAndView agregar(@ModelAttribute Users user) {
		if (user.getPassword().equals(user.getPasswordConfirmation())) {			
			user.setPassword(encoder.encode(user.getPassword()));
			user.setPasswordConfirmation(user.getPassword());			
			Users usuario = userService.add(user);
			if (usuario == null) {
				return new ModelAndView("redirect:/registrarse");
			}
		} 
		return new ModelAndView("redirect:/login");		
	}	
}
